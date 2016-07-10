package com.nc.j2ee.servlets;

import com.nc.j2ee.*;
import com.nc.j2ee.embeded.AttrObject;
import com.nc.j2ee.embeded.AttrObjectType;
import com.nc.j2ee.interfaces.TTAttrObjectTypeInterface;
import com.nc.j2ee.interfaces.TTAttributeInterface;
import com.nc.j2ee.interfaces.TTObjectInterface;
import com.nc.j2ee.interfaces.TTParamsInterface;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Map;

/**
 * Servlet for editing item
 * Created by Vlad on 29.06.2016.
 */
public class EditServlet extends HttpServlet implements javax.servlet.Servlet {

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBWorker dbWorker = new DBWorker();
        Map<String, String[]> parameters = request.getParameterMap();

        String productId = Utils.toUTF8Request(parameters.get("product_id")[0].trim());
        Long objectId = dbWorker.getObjectIdForValue(productId);
        Long objectTypeId = dbWorker.getObjectTypeIdForObject(objectId);

        for(String parameter : parameters.keySet()) {
            if(parameter.equals("action") || parameter.equals("product_id")) {
                continue;
            }

            if(parameter.equals("name")) {
                TTObject object = new TTObject();
                object.setObjectId(objectId);
                object.setObjectTypeId(objectTypeId);
                object.setVersion(dbWorker.getVersionForObject(objectId)+1);
                object.setName(Utils.toUTF8Request(parameters.get("name")[0]));
                objectI.update(object);
            }

            Long attrId;

            if((attrId=dbWorker.getAttrIdForName(parameter))!=0L) {
                AttrObject attrObject = new AttrObject(attrId,objectId);
                paramsI.update(new TTParams(attrObject,dbWorker.getAttrAccessType(attrId),Utils.toUTF8Request(parameters.get(parameter)[0])));
            } else {
                System.out.println(parameter);
                Long newAttrId = attributeI.create(new TTAttributes(parameter,0L));

                TTAttrObjectTypes attrObjectTypes = new TTAttrObjectTypes();
                attrObjectTypes.setAttrObjectEmbedded(new AttrObjectType(newAttrId,objectTypeId));
                attrObjectTypeI.create(attrObjectTypes);

                AttrObject attrObject = new AttrObject(newAttrId,objectId);
                paramsI.update(new TTParams(attrObject,0L,Utils.toUTF8Request(parameters.get(parameter)[0])));
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

        paramsI.update(new TTParams(new AttrObject(37L,objectId),dbWorker.getAttrAccessType(37L),new Date(Utils.getCurrentTimeLong())));
        paramsI.update(new TTParams(new AttrObject(39L,objectId),dbWorker.getAttrAccessType(39L),""+dbWorker.getObjectIdForValue(userName)));
        response.sendRedirect("index.jsp");

    }
}
