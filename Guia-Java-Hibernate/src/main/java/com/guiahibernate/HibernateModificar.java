package com.guiahibernate;

import com.guiahibernate.entity.Cliente;
import com.guiahibernate.utilities.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;

public class HibernateModificar {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        try {
            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del cliente a modificar"));
            Cliente cliente = entityManager.find(Cliente.class, id);

            String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente");
            String apellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido del cliente");

            entityManager.getTransaction().begin();

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            entityManager.merge(cliente);

            entityManager.getTransaction().commit();

            Query query = entityManager.createQuery("select c from Cliente c", Cliente.class);
            query.getResultList().forEach(System.out::println);

        }catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }finally {
            entityManager.close();
        }
    }
}
