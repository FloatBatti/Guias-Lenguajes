package com.agus.webapp.Controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebServlet(name = "logoutServlet2", value = "/logout-servlet-2")
public class LogoutServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

        String username = (String) req.getSession().getAttribute("username");

        req.getSession().setAttribute("username", username);

        if(username != null){

            HttpSession session = req.getSession();
            session.invalidate(); // Cierra la sesión.
        }

        try {
            resp.sendRedirect("index.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
