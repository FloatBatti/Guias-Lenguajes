package com.guiahibernate;

import com.guiahibernate.entity.Cliente;
import com.guiahibernate.utilities.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Queue;

public class HibernateListar {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        // En el primer parámetro se indica la consulta a realizar, en este caso se busca un objeto c de tipo Cliente.
        // Se está utilizando HQL (Hibernate Query Language), que es un lenguaje de consultas orientado a objetos.
        List<Cliente> listaClientes = entityManager.createQuery("select c from Cliente c", Cliente.class).
                getResultList();

        // Se recorre la lista de clientes y se imprime cada uno de ellos.
        listaClientes.forEach(System.out::println);

        System.out.println("---------------------------------------------------");

        Query query = entityManager.createQuery("select c from Cliente c where c.id = ?1");
        query.setParameter(1, 2);

        Cliente cliente = (Cliente) query.getSingleResult(); // Se obtiene un único resultado.

        System.out.println(cliente);

        System.out.println("---------------------------------------------------");

        // Con el método find se obtiene un objeto de tipo Cliente a partir de su id.
        // Él id es el atributo que se encuentra anotado con @Id en la clase Cliente.
        Cliente cliente2 = entityManager.find(Cliente.class, 3);

        System.out.println(cliente2);

        System.out.println("---------------------------------------------------");

        query = entityManager.createQuery("select c from Cliente c where c.formaPago = :formaPago", Cliente.class);

        query.setParameter("formaPago", "Tarjeta");

        List<Cliente> listaTarjeta = query.getResultList();

        listaTarjeta.forEach(System.out::println);

        // Se cierra el EntityManager.
        entityManager.close();

    }
}
