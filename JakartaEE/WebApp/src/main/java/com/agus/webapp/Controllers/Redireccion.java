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
            response.sendRedirect("index.jsp"); // Redirecciona a index.jsp. Se usa response en lugar de
            // request porque se quiere redireccionar, no obtener.
            // La diferencia entre sendRedirect() y forward() es que sendRedirect() envía una nueva solicitud al
            // servidor, mientras que forward() reenvía la solicitud actual al recurso especificado.
        } catch (Exception e) {
            System.out.println("Error al redireccionar: " + e);
        }
    }
}
