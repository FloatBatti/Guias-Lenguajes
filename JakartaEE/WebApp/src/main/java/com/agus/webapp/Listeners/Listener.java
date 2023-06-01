package com.agus.webapp.Listeners;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import jakarta.servlet.annotation.WebListener;

@WebListener // Un listener es un objeto que se encarga de escuchar eventos que suceden en el servidor.
public class Listener implements ServletContextListener, ServletRequestListener, HttpSessionListener {

    private ServletContext context = null;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().log("Aplicación iniciada");
        context = sce.getServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        context.log("Aplicación destruida");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        context.log("Request iniciado");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        context.log("Request destruido");
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        context.log("Sesión creada");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        context.log("Sesión destruida");
    }
}
