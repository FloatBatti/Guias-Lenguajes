package com.guiahibernate.repositories;

import com.guiahibernate.entity.Cliente;
import jakarta.persistence.EntityManager;
import java.util.List;

// Un repositorio representa una capa de acceso a datos que se utiliza para interactuar con una fuente de datos,
// como una base de datos, un servicio web o cualquier otro medio de almacenamiento persistente.
// Los repositorios se centran en las operaciones de persistencia y proporcionan métodos para recuperar, guardar,
// actualizar y eliminar entidades en la fuente de datos.
public class ClienteRepository implements CrudRepository<Cliente>{

    private final EntityManager entityManager;

    public ClienteRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Cliente> listar() {
        return entityManager.createQuery("select c from Cliente c", Cliente.class).getResultList();
    }

    @Override
    public Cliente porId(int id) {
        return entityManager.find(Cliente.class, id);
    }

    @Override
    public void guardar(Cliente objeto) {
        entityManager.persist(objeto);
    }

    @Override
    public void eliminar(int id) {
        entityManager.remove(porId(id));
    }

    @Override
    public void actualizar(Cliente objeto) {
        entityManager.merge(objeto);
    }
}
