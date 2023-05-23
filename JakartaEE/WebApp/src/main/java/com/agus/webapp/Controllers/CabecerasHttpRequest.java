package com.agus.webapp.Controllers;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.PrintWriter;

@WebServlet(name = "cabecerasHttpRequest", value = "/cabeceras-http-request")
public class CabecerasHttpRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){

        String method = request.getMethod(); // Devuelve el método HTTP utilizado para esta solicitud.
        String requestURI = request.getRequestURI(); // Devuelve la parte de la solicitud URI que se utiliza para
        // seleccionar el recurso. La solicitud URI es lo que viene después del nombre de host y el puerto.
        String protocol = request.getProtocol(); // Devuelve el nombre y la versión del protocolo utilizado para
        // esta solicitud.
        String requestURL = request.getRequestURL().toString(); // Devuelve el url completo de la solicitud.
        String contextPath = request.getContextPath(); // Devuelve el contexto de la aplicación web.
        String servletPath = request.getServletPath(); // Devuelve la parte de la solicitud URI que se utiliza para
        // seleccionar el servlet.
        String remoteAddr = request.getRemoteAddr(); // Devuelve la dirección IP del cliente que envió la solicitud.
        String remoteHost = request.getRemoteHost(); // Devuelve el nombre del host del cliente que envió la solicitud.
        String remoteUser = request.getRemoteUser(); // Devuelve el nombre del usuario que envió la solicitud.
        String authType = request.getAuthType(); // Devuelve el esquema de autenticación utilizado para proteger el
        // servlet.
        String localAddr = request.getLocalAddr(); // Devuelve la dirección IP del servidor que recibe la solicitud.
        String localName = request.getLocalName(); // Devuelve el nombre del servidor que recibe la solicitud.
        String serverName = request.getServerName(); // Devuelve el nombre del servidor que recibe la solicitud.
        int serverPort = request.getServerPort(); // Devuelve el número de puerto del servidor que recibe la solicitud.
        String scheme = request.getScheme(); // Devuelve el nombre del esquema utilizado para hacer esta solicitud,
        // por ejemplo, http, https o ftp.
        String queryString = request.getQueryString(); // Devuelve la parte de la cadena de consulta de esta URL.
        String contentType = request.getContentType(); // Devuelve el tipo MIME del cuerpo de la solicitud, o null si
        // no se conoce el tipo de contenido.
        int contentLength = request.getContentLength(); // Devuelve el tamaño del cuerpo de la solicitud en bytes.
        String characterEncoding = request.getCharacterEncoding(); // Devuelve el nombre de codificación de caracteres
        // del cuerpo de la solicitud.
        String accept = request.getHeader("Accept"); // Devuelve el valor de la cabecera de solicitud Accept.
        String acceptEncoding = request.getHeader("Accept-Encoding"); // Devuelve el valor de la cabecera de solicitud
        // Accept-Encoding.
        String acceptLanguage = request.getHeader("Accept-Language"); // Devuelve el valor de la cabecera de solicitud
        // Accept-Language.

        try(PrintWriter out = response.getWriter()) {

            response.setContentType("text/html");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cabeceras HTTP Request</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cabeceras HTTP Request</h1>");

            out.println("<li>Method: " + method + "</li>");
            out.println("<li>Request URI: " + requestURI + "</li>");
            out.println("<li>Protocol: " + protocol + "</li>");
            out.println("<li>Request URL: " + requestURL + "</li>");
            out.println("<li>Context Path: " + contextPath + "</li>");
            out.println("<li>Servlet Path: " + servletPath + "</li>");
            out.println("<li>Remote Addr: " + remoteAddr + "</li>");
            out.println("<li>Remote Host: " + remoteHost + "</li>");
            out.println("<li>Remote User: " + remoteUser + "</li>");
            out.println("<li>Auth Type: " + authType + "</li>");
            out.println("<li>Local Addr: " + localAddr + "</li>");
            out.println("<li>Local Name: " + localName + "</li>");
            out.println("<li>Server Name: " + serverName + "</li>");
            out.println("<li>Server Port: " + serverPort + "</li>");
            out.println("<li>Scheme: " + scheme + "</li>");
            out.println("<li>Query String: " + queryString + "</li>");
            out.println("<li>Content Type: " + contentType + "</li>");
            out.println("<li>Content Length: " + contentLength + "</li>");
            out.println("<li>Character Encoding: " + characterEncoding + "</li>");
            out.println("<li>Accept: " + accept + "</li>");
            out.println("<li>Accept Encoding: " + acceptEncoding + "</li>");
            out.println("<li>Accept Language: " + acceptLanguage + "</li>");
            out.println("</body>");

            out.println("</html>");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
