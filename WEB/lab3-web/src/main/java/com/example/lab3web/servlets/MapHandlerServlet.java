package com.example.lab3web.servlets;

import com.example.lab3web.data.Point;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import database.PointDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
public class MapHandlerServlet extends HttpServlet {
    private final PointDAO pointDAO = new PointDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (!request.getParameter("mode").equals("map"))
            response.sendError(403); // conflict

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new SimpleModule());
        response.getWriter().write(objectMapper.writeValueAsString(pointDAO.getPoints().toArray(new Point[0])));
    }
}
