package com.nc.j2ee.servlets;


import com.nc.j2ee.impl.DBWorkerImpl;
import com.nc.j2ee.Utils;
import com.nc.j2ee.interfaces.DBWorkerInterface;
import com.nc.j2ee.interfaces.TTAttrObjectTypeInterface;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for user login
 * Created by Vlad on 25.06.2016.
 */
public class LoginServlet extends HttpServlet implements javax.servlet.Servlet {

    @EJB(name = "ejb/attrObjectType")
    /**Attribute object type EJB*/
    private TTAttrObjectTypeInterface object;

    @EJB(name="ejb/dbWorker")
    /**DBWorker*/
    DBWorkerInterface dbWorkerI;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = Utils.toUTF8Request(request.getParameter("username"));

        if(dbWorkerI.getObjectIdForValue(username)==null) {
            request.getSession().setAttribute("result", "error1");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
            return;
        }

        String password = Utils.md5Custom(Utils.toUTF8Request(request.getParameter("password")));

        if(dbWorkerI.getPasswordForUsername(username)!=null && !dbWorkerI.getPasswordForUsername(username).equals(password)) {
            request.getSession().setAttribute("result", "error2");
            RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
            rd.forward(request, response);
            return;
        }

        Cookie loginCookie = new Cookie("user",username);
        Cookie adminCookie = new Cookie("admin",""+dbWorkerI.isAdmin(username));
        loginCookie.setMaxAge(30*60);
        adminCookie.setMaxAge(30*60);
        response.addCookie(loginCookie);
        response.addCookie(adminCookie);
        response.sendRedirect("index.jsp");
    }

}
