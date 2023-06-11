package com.guiahibernate;

import com.guiahibernate.entity.Cliente;
import com.guiahibernate.utilities.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.Scanner;

public class HibernateEliminar {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el id del cliente a eliminar: ");
        int id = scanner.nextInt();

        try {
            entityManager.getTransaction().begin();

            entityManager.remove(entityManager.find(Cliente.class, id));

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
