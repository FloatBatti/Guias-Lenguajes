package com.agus.webapp.Controllers;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

// La anotación @WebServlet indica que la clase es un servlet.
// El atributo name especifica el nombre del servlet.
// El atributo value especifica la URL del servlet que vamos a utilizar para acceder al servlet.
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {

    // El método doPost() se utiliza para manejar las solicitudes POST.
    // HttpServletRequest y HttpServletResponse son objetos de solicitud y respuesta respectivamente.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        String pais = request.getParameter("pais");

        String[] lenguajes = request.getParameterValues("lenguajes");
        String[] roles = request.getParameterValues("roles");

        String idioma = request.getParameter("idioma");
        String habilitar = request.getParameter("habilitar");

        HashMap<String, String> errorsMap = new HashMap<>();

        // Se validan los campos:

        // isBlank() es un método de Java 11 que verifica si un String es nulo o vacío.
        if (username == null || username.isBlank()) {
            errorsMap.put("username", "El campo username es requerido");
        }

        if (password == null || password.isBlank()) {
            errorsMap.put("password", "El campo password es requerido");
        }

        if (email == null || email.isBlank()) {
            errorsMap.put("email", "El campo email es requerido");
        }


        if(errorsMap.isEmpty()){

            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
            System.out.println("Email: " + email);
            System.out.println("Pais: " + pais);
            System.out.println("Lenguajes: " + Arrays.toString(lenguajes));
            System.out.println("Roles: " + Arrays.toString(roles));
            System.out.println("Idioma: " + idioma);

        }else{

            // setAttribute() se utiliza para establecer un atributo en el objeto request que se pasará al JSP.
            // En este caso, se establece el atributo "errores" con el valor de la variable errores. Esto permite
            // transmitir información o datos adicionales al JSP para su posterior procesamiento o visualización.
            request.setAttribute("errorsMap", errorsMap);

            // getServletContext() se utiliza para obtener el objeto ServletContext, es decir, el contexto de la
            // aplicación.
            // getRequestDispatcher() se utiliza para obtener el objeto RequestDispatcher que actúa como un
            // objeto de despacho. Un objeto de despacho es un objeto que puede enviar la solicitud al recurso
            // interno, como el servlet, el JSP o el HTML.
            // El método forward() del objeto RequestDispatcher se utiliza para enviar la solicitud al recurso
            // interno. Toma dos argumentos, la solicitud y el objeto de respuesta.
            // El método forward() realiza una redirección interna en el servidor sin que el cliente sea consciente
            // de ello. La solicitud y la respuesta se transfieren al JSP, donde se realiza el procesamiento
            // adicional.
            try {
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            }

            /*

            Se establece un atributo llamado "errores" en la solicitud actual utilizando el método
            request.setAttribute(). Esto puede ser útil para transmitir información o datos adicionales al
            recurso al que se va a redirigir.

            Luego, se obtiene un objeto RequestDispatcher para el archivo JSP "/index.jsp" utilizando el método
            getServletContext().getRequestDispatcher(). Esto permite reenviar la solicitud actual al JSP
            "/index.jsp" para su procesamiento adicional.

            Finalmente, se llama al método forward() del objeto RequestDispatcher para redirigir la solicitud
            actual al archivo JSP "/index.jsp". Esto significa que la solicitud y la respuesta se transfieren
            al JSP, y el procesamiento continúa en el JSP.
             */
        }


    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){

    }
    public void destroy() {
    }
}