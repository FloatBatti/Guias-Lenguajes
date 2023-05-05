package org.agusbatti.java;

import org.agusbatti.java.models.Producto;
import org.agusbatti.java.repositorio.ProductoRepo;
import org.agusbatti.java.repositorio.Repositorio;

import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        try(Connection connection = Conexion.getInstance()){

            Repositorio<Producto> productoRepo = new ProductoRepo();

            productoRepo.listar().forEach(System.out::println);

            System.out.println("-------------------------------------------------");

            System.out.println("Producto con id 2 -> " + productoRepo.buscarPorId(2));

            System.out.println("-------------------------------------------------");

            //Producto producto = new Producto(0,"Coca Cola", 50, new Date());

            //productoRepo.guardar(producto);

            //productoRepo.listar().forEach(System.out::println);

            System.out.println("-------------------------------------------------");

            //productoRepo.eliminar(4);

            //productoRepo.listar().forEach(System.out::println);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}