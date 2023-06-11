package com.agus.webapp.Controllers;

import com.agus.webapp.Models.Producto;
import com.agus.webapp.Services.ProductService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "productSessionServlet", value = "/product-session-servlet")
public class ProductSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response){

        ProductService productService = new ProductService();

        List<Producto> products = productService.listar();

        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listado de productos con Session</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de productos</h1>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Id</th>");
            out.println("<th>Nombre</th>");
            out.println("<th>Descripcion</th>");
            out.println("<th>Precio</th>");
            out.println("</tr>");

            products.forEach(p ->{
                out.println("<tr>");
                out.println("<td>" + p.getId() + "</td>");
                out.println("<td>" + p.getNombre() + "</td>");
                out.println("<td>" + p.getDescripcion() + "</td>");
                out.println("<td>" + p.getPrecio() + "</td>");
                out.println("</tr>");
            });

            out.println("</table>");
            out.println("<a href=\"logout-session-servlet\">Cerrar sesión</a>");
            out.println("<a href=\"redireccion\">Volver</a>");
            out.println("</body>");
            out.println("</html>");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
