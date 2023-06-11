package com.guiahibernate;

import com.guiahibernate.entity.Cliente;
import com.guiahibernate.entity.Direccion;
import com.guiahibernate.utilities.JpaUtil;
import jakarta.persistence.EntityManager;

public class OneToMany {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            Cliente cliente = new Cliente("Carlos", "Gomez", "Efectivo");
            // Las direcciones van a persistirse en cascada junto con el cliente.
            Direccion direccion1 = new Direccion("Calle 1", "123");
            Direccion direccion2 = new Direccion("Calle 2", "456");

            cliente.getDirecciones().add(direccion1);
            cliente.getDirecciones().add(direccion2);

            em.persist(cliente);

            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally {
            em.close();
        }
    }
}
