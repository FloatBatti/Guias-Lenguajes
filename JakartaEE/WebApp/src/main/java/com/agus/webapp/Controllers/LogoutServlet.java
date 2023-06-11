package com.agus.webapp.Controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@WebServlet(name = "logoutServlet", value = "/logout-servlet")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){

        Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];
        Optional<String> cookie = Arrays.stream(cookies).filter(
                        c -> c.getName().equals("username")).
                map(Cookie::getValue).
                findAny();

        if(cookie.isPresent()){

            Cookie cookie1 = new Cookie("username", "");
            cookie1.setMaxAge(0); // 0 segundos para que expire de forma automática.
            resp.addCookie(cookie1); // Se agrega la cookie a la respuesta. No se agrega al request porque se quiere
            // eliminar, no obtener.
        }

        try {
            resp.sendRedirect("index.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
