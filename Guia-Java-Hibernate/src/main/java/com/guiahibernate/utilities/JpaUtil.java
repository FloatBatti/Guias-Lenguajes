package com.guiahibernate.utilities;

import jakarta.persistence.*;

public class JpaUtil {

    // Al ser un atributo estático, se va a crear una sola vez en la aplicación cuando se cargue la clase.
    // Se está utilizando el patrón Singleton.
    private static final EntityManagerFactory entityManagerFactory = buildEntityManagerFactory();

    // El siguiente método es para crear el EntityManagerFactory, que es el encargado de crear los EntityManager.
    // EntityManager es el encargado de realizar las operaciones de persistencia en la base de datos.
    // El EntityManagerFactory es un objeto pesado, por lo que se debe crear una sola vez en la aplicación.
    private static EntityManagerFactory buildEntityManagerFactory(){
        return Persistence.createEntityManagerFactory("guiaHibernate");
    }

    // Con el siguiente método se obtiene la instancia del EntityManagerFactory.
    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }
}
