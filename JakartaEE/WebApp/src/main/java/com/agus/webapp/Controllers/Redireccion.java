package com.agus.webapp.Controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "redireccion", value = "/redireccion")
public class Redireccion extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            response.sendRedirect("index.jsp"); // Redirecciona a index.jsp, redirecciona a la pagina principal, incluyendo el request y el response
        } catch (Exception e) {
            System.out.println("Error al redireccionar: " + e);
        }
    }
}
