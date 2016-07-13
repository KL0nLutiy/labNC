package com.nc.j2ee.servlets;

import com.nc.j2ee.impl.DBWorkerImpl;
import com.nc.j2ee.TTObject;
import com.nc.j2ee.TTParams;
import com.nc.j2ee.Utils;
import com.nc.j2ee.embeded.AttrObject;
import com.nc.j2ee.interfaces.DBWorkerInterface;
import com.nc.j2ee.interfaces.TTObjectInterface;
import com.nc.j2ee.interfaces.TTParamsInterface;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

/**
 * Servlet for registration
 * Created by Vlad on 24.06.2016.
 */
public class RegistrationServlet extends HttpServlet implements javax.servlet.Servlet {

    @EJB(name = "ejb/object")
    /**Object EJB*/
    private TTObjectInterface objectI;

    @EJB(name = "ejb/params")
    /**Parameters EJB*/
    private TTParamsInterface paramsI;

    @EJB(name="ejb/dbWorker")
    /**DBWorker*/
    DBWorkerInterface dbWorkerI;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String username = Utils.toUTF8Request(request.getParameter("username"));
            String email = Utils.toUTF8Request(request.getParameter("email"));

            String errors = "";

            if(!username.isEmpty() && dbWorkerI.getAttrIdForValue(username)!=null) {
                    errors+="error1";
            }

            if(!email.isEmpty() && dbWorkerI.getAttrIdForValue(email)!=null){
                    errors+="error2";
            }

            if(!errors.isEmpty()) {
                    request.getSession().setAttribute("result", errors);
                    RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
                    rd.forward(request, response);
                    return;
            }


            TTObject object = new TTObject();
            object.setVersion(1L);
            object.setDescription("Shop customer");
            object.setObjectTypeId(2L);
            object.setName(username);

            long id = objectI.create(object);
            long userId = dbWorkerI.getId();

            paramsI.create(new TTParams(new AttrObject(7L,id),dbWorkerI.getAttrAccessType(7L),""+userId));
            paramsI.create(new TTParams(new AttrObject(2L,id),dbWorkerI.getAttrAccessType(2L),username));
            paramsI.create(new TTParams(new AttrObject(3L,id),dbWorkerI.getAttrAccessType(3L),Utils.md5Custom(request.getParameter("password"))));
            paramsI.create(new TTParams(new AttrObject(4L,id),dbWorkerI.getAttrAccessType(4L),Utils.toUTF8Request(request.getParameter("firstname"))));
            paramsI.create(new TTParams(new AttrObject(5L,id),dbWorkerI.getAttrAccessType(5L),Utils.toUTF8Request(request.getParameter("secondname"))));
            paramsI.create(new TTParams(new AttrObject(6L,id),dbWorkerI.getAttrAccessType(6L),email));
            paramsI.create(new TTParams(new AttrObject(8L,id),dbWorkerI.getAttrAccessType(8L),Utils.toUTF8Request(request.getParameter("phone"))));
            paramsI.create(new TTParams(new AttrObject(36L,id),dbWorkerI.getAttrAccessType(36L),new Date(Utils.getCurrentTimeLong())));
            paramsI.create(new TTParams(new AttrObject(37L,id),dbWorkerI.getAttrAccessType(37L),new Date(Utils.getCurrentTimeLong())));
            paramsI.create(new TTParams(new AttrObject(38L,id),dbWorkerI.getAttrAccessType(38L),""+userId));
            paramsI.create(new TTParams(new AttrObject(39L,id),dbWorkerI.getAttrAccessType(39L),""+userId));

            request.getSession().setAttribute("result", "Registration successful");
            RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
            rd.forward(request, response);
    }
}
