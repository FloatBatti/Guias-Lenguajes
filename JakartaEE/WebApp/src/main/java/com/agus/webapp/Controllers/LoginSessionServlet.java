package com.agus.webapp.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;


@WebServlet(name = "loginSessionServlet", value = "/login-session-servlet")
public class LoginSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        if(username != null){

            try {
                resp.sendRedirect("product-session-servlet");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            getServletContext().getRequestDispatcher("/login-session.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username.equals("admin") && password.equals("1234")) {

            req.getSession().setAttribute("username", username);

            try {
                resp.sendRedirect("product-session-servlet");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{

            try {
                resp.sendRedirect("/index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
