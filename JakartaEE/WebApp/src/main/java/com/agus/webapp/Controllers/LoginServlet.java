package com.agus.webapp.Controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebServlet(name = "loginServlet", value = "/login-servlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];
        // Se usa operador ternario para evitar NullPointerException.
        // Se usa un Optional para evitar NullPointerException.
        // getNombre() es un método de la clase Cookie que devuelve el nombre de la cookie.
        // La cookie la busca en el cliente.
        Optional<String> cookie = Arrays.stream(cookies).filter(
                c -> c.getName().equals("username")).
                map(Cookie::getValue).
                findAny(); // con findAny() se obtiene el primer elemento que coincida con el filtro.

        if(cookie.isPresent()){
            try {
                resp.sendRedirect("product-servlet");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp){

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username.equals("admin") && password.equals("1234")) {


            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60 * 24 * 30); // Se configura la cookie para que expire en 30 días.
            // La cookie se almacena en el cliente.
            resp.addCookie(cookie); // Se agrega la cookie a la respuesta.

            // Se redirecciona al servlet de productos:

            try {
                resp.sendRedirect("product-servlet");
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
