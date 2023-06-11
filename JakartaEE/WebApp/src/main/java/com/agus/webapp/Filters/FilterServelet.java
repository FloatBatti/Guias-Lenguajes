package com.agus.webapp.Filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// Los filtros son objetos que se encargan de interceptar las peticiones que se realizan al servidor.
// Se pueden usar para validar que el usuario esté logueado, para validar que el usuario tenga permisos para
// acceder a ciertas páginas, etc. Son componentes flexibles que permiten agregar funcionalidad adicional a la
// cadena de procesamiento de solicitudes y respuestas HTTP en una aplicación web. Se utilizan para realizar
// tareas como autenticación, autorización, compresión, logging, manipulación de datos, seguridad y optimización
// del rendimiento.
// Los filtros se ejecutan antes de que se ejecute el servlet al que se le hizo la petición. Por eso, se indican,
// en el urlPatterns, los servlets a los que se les va a aplicar el filtro.
@WebFilter(filterName = "filterServlet", urlPatterns = {"/product-session-servlet", "/logout-servlet-2"})
public class FilterServelet implements Filter {

    @Override
    // FilerChain es una interfaz que permite encadenar filtros. Se utiliza para invocar el siguiente filtro
    // en la cadena, o si el filtro que se está ejecutando es el último, invocar al servlet al que se le hizo
    // la petición.
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) req).getSession();
        String username = (String) session.getAttribute("username");

        if(username != null){
            // Si el usuario está logueado, se ejecuta el siguiente filtro en la cadena, o si es el último,
            // se ejecuta el servlet al que se le hizo la petición.
            filterChain.doFilter(req, resp);
        }else{
            // Si el usuario no está logueado, se envía un error 401 (Unauthorized) al cliente.
            ((HttpServletResponse) resp).sendError(HttpServletResponse.SC_UNAUTHORIZED, "No autorizado, debe loguearse para ver el contenido");
        }

    }
}
