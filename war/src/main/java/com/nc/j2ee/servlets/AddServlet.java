package com.nc.j2ee.servlets;

import com.nc.j2ee.*;
import com.nc.j2ee.embeded.AttrObject;
import com.nc.j2ee.embeded.AttrObjectType;
import com.nc.j2ee.impl.DBWorkerImpl;
import com.nc.j2ee.interfaces.*;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.*;
import java.io.*;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * Servlet for adding new item(product)
 * Created by Vlad on 30.06.2016.
 */

@MultipartConfig
public class AddServlet extends HttpServlet implements javax.servlet.Servlet {

    public final static String imgPath = "C:\\image\\img\\";

    /**
     * Logger for logging info and errors
     */
    private static final Logger log = Logger.getLogger(AddServlet.class);

    @EJB(name = "ejb/object")
    /**Object EJB*/
    TTObjectInterface objectI;

    @EJB(name = "ejb/params")
    /**Parameters EJB*/
    TTParamsInterface paramsI;

    @EJB(name = "ejb/attributes")
    /**Attribute EJB*/
    TTAttributeInterface attributeI;

    @EJB(name = "ejb/attrObjectType")
    /**Attribute object type EJB*/
    TTAttrObjectTypeInterface attrObjectTypeI;

    @EJB(name="ejb/dbWorker")
    /**DBWorker*/
    DBWorkerInterface dbWorkerI;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selectedType = Utils.toUTF8Request(request.getParameter("goodsType"));
        List<String> list = dbWorkerI.getAttrsForGoods(Long.parseLong(selectedType));

        request.getSession().setAttribute("list", list);
        request.getSession().setAttribute("goodsType", selectedType);
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameters = request.getParameterMap();

        Long objectTypeId = Long.parseLong(parameters.get("goodsType")[0]);

        TTObject object = new TTObject();
        object.setObjectTypeId(objectTypeId);
        object.setName(Utils.toUTF8Request(parameters.get("name")[0]));
        Long objectId = objectI.create(object);

        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();
        OutputStream outputStream = null;

        try {

            outputStream =
                    new FileOutputStream(new File(imgPath+objectId+".jpg"));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = fileContent.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            log.info("Img for object id: "+objectId+" added success");

        } catch (IOException e) {
            e.printStackTrace();
            log.error("Can't add img for object id: "+objectId+" "+e.getMessage(), e);
        } finally {
            if (fileContent != null) {
                try {
                    fileContent.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
        paramsI.create(new TTParams(new AttrObject(40L,objectId),dbWorkerI.getAttrAccessType(40L),"img/"+objectId+".jpg"));

        for(String parameter : parameters.keySet()) {
            if(parameter.equals("action") || parameter.equals("name") || parameter.equals("file") || parameter.equals("goodsType")) {
                continue;
            }

            Long attrId;

            if((attrId=dbWorkerI.getAttrIdForName(parameter))!=0L) {
                if(Utils.toUTF8Request(parameters.get(parameter)[0]).equals("")) {
                    continue;
                }
                AttrObject attrObject = new AttrObject(attrId,objectId);
                paramsI.create(new TTParams(attrObject,dbWorkerI.getAttrAccessType(attrId),Utils.toUTF8Request(parameters.get(parameter)[0])));
            } else {
                Long newAttrId = attributeI.create(new TTAttributes(parameter,0L));

                TTAttrObjectTypes attrObjectTypes = new TTAttrObjectTypes();
                attrObjectTypes.setAttrObjectEmbedded(new AttrObjectType(newAttrId,objectTypeId));
                attrObjectTypeI.create(attrObjectTypes);

                AttrObject attrObject = new AttrObject(newAttrId,objectId);
                paramsI.create(new TTParams(attrObject,0L,Utils.toUTF8Request(parameters.get(parameter)[0])));
            }
        }

        String userName = null;
        Cookie[] cookies = request.getCookies();
        if(cookies !=null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("user")) {
                    userName = cookie.getValue();
                }
            }
        }

        paramsI.create(new TTParams(new AttrObject(36L,objectId),dbWorkerI.getAttrAccessType(36L),new Date(Utils.getCurrentTimeLong())));
        paramsI.create(new TTParams(new AttrObject(37L,objectId),dbWorkerI.getAttrAccessType(37L),new Date(Utils.getCurrentTimeLong())));
        paramsI.create(new TTParams(new AttrObject(38L,objectId),dbWorkerI.getAttrAccessType(38L),""+dbWorkerI.getObjectIdForValue(userName)));
        paramsI.create(new TTParams(new AttrObject(39L,objectId),dbWorkerI.getAttrAccessType(39L),""+dbWorkerI.getObjectIdForValue(userName)));
        response.sendRedirect("index.jsp");
    }
}
