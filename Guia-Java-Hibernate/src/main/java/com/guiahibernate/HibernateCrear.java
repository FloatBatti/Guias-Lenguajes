package com.guiahibernate;

import com.guiahibernate.entity.Cliente;
import com.guiahibernate.utilities.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import javax.swing.*;

public class HibernateCrear {

    public static void main(String[] args) {

        EntityManager entityManager = JpaUtil.getEntityManager();

        // Las transacciones se utilizan para agrupar un conjunto de operaciones
        // que se deben realizar en forma atómica, es decir, si una de las operaciones falla, se debe deshacer
        // todas las operaciones que se hayan hecho hasta ese momento. Esto sirve para mantener la integridad
        // de los datos. Por ejemplo, si se quiere transferir dinero de una cuenta a otra, se debe descontar
        // el dinero de la cuenta origen y sumarlo a la cuenta destino. Si se descuenta el dinero de la cuenta
        // origen y luego falla la operación de sumar el dinero a la cuenta destino, se debe deshacer la operación
        // de descontar el dinero de la cuenta origen, ya que si no se hace, se estaría perdiendo dinero.
        try{

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente");
            String apellido = JOptionPane.showInputDialog("Ingrese el apellido del cliente");
            String formaPago = JOptionPane.showInputDialog("Ingrese la forma de pago del cliente");

            entityManager.getTransaction().begin(); // Se inicia la transacción.

            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setFormaPago(formaPago);

            // Con el método persist se guarda el objeto cliente en la base de datos. Es como el insert de SQL.
            entityManager.persist(cliente);

            entityManager.getTransaction().commit(); // Se confirma la transacción.

            Query query = entityManager.createQuery("select c from Cliente c", Cliente.class);

            query.getResultList().forEach(System.out::println);

        }catch (Exception e){
            e.printStackTrace(); // Se imprime el error.
            entityManager.getTransaction().rollback(); // Si falla la transacción, se deshacen todas las operaciones.

        }finally {
            entityManager.close(); // Se cierra el EntityManager.
        }



    }
}
