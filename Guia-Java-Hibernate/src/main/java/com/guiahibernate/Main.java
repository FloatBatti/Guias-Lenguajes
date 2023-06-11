package com.guiahibernate;

import com.guiahibernate.entity.Cliente;
import com.guiahibernate.services.ClienteServiceImpl;
import com.guiahibernate.utilities.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import javax.swing.*;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();
        ClienteServiceImpl clienteService = new ClienteServiceImpl(entityManager);

        System.out.println("=========== LISTAR ===========");
        clienteService.listar().forEach(System.out::println);

        System.out.println("=========== BUSCAR POR ID ===========");
        Optional<Cliente> clienteOptional = clienteService.porId(2);
        clienteOptional.ifPresent(System.out::println);

        System.out.println("=========== GUARDAR ===========");
        Cliente cliente = new Cliente("Barbara", "Ferreyra", "Tarjeta");
        clienteService.guardar(cliente);
        clienteService.listar().forEach(System.out::println);

        System.out.println("=========== ELIMINAR ===========");
        Query query = entityManager.createQuery("select c from Cliente c where c.id = (select max(c.id) from Cliente c)");
        Cliente cliente2 = (Cliente) query.getSingleResult();
        clienteService.eliminar(cliente2.getId());
        clienteService.listar().forEach(System.out::println);

        System.out.println("=========== ACTUALIZAR ===========");
        clienteService.actualizar();

        clienteService.listar().forEach(System.out::println);

        entityManager.close();


    }
}
