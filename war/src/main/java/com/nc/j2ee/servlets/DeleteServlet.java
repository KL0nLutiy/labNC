package com.nc.j2ee.servlets;


import com.nc.j2ee.Utils;
import com.nc.j2ee.interfaces.TTObjectInterface;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet for deleting item
 * Created by Vlad on 29.06.2016.
 */
public class DeleteServlet extends HttpServlet implements javax.servlet.Servlet {

    @EJB
    /**Object EJB*/
    TTObjectInterface object;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String objectId = Utils.toUTF8Request(request.getParameter("objectId"));
        String pageName = Utils.toUTF8Request(request.getParameter("pageName"));

        object.delete(Long.parseLong(objectId));
        response.sendRedirect(pageName);
    }
}
