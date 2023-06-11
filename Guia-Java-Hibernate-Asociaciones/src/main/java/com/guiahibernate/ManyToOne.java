package com.guiahibernate;

import com.guiahibernate.entity.Cliente;
import com.guiahibernate.entity.Factura;
import com.guiahibernate.utilities.JpaUtil;
import jakarta.persistence.EntityManager;

public class ManyToOne {

    public static void main(String[] args) {

        EntityManager em = JpaUtil.getEntityManager();

        try {

            em.getTransaction().begin();
            Cliente cliente = new Cliente("Sofia", "Lopez", "Crédito");
            em.persist(cliente);

            Factura factura = new Factura("Compra de muebles", 100000L);
            // Tener en cuenta que el cliente debe estar persistido antes de asignarlo a la factura.
            factura.setCliente(cliente);
            em.persist(factura);

            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally {
            em.close();
        }

    }
}
