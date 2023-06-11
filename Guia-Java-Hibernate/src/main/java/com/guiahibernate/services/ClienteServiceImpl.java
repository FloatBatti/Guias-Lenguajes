package com.guiahibernate.services;

import com.guiahibernate.entity.Cliente;
import com.guiahibernate.repositories.ClienteRepository;
import jakarta.persistence.EntityManager;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

// El service trabaja con el repository.
// También se encarga de manejar las transacciones.
// El service es la capa más alta de la aplicación. Encapsula la lógica de negocio, y suele ser responsable de
// realizar operaciones como la validación de datos, el procesamiento de la lógica empresarial y la coordinación
// entre diferentes componentes.
// Un servicio puede interactuar con uno o varios repositorios para obtener o persistir los datos necesarios
// para realizar su función. Además, puede comunicarse con otros servicios o componentes externos según sea
// necesario.
// Los servicios representan la capa de lógica de negocio y coordinación, mientras que los repositorios se centran
// en el acceso y la persistencia de los datos. Los servicios interactúan con los repositorios para obtener o
// almacenar los datos necesarios para llevar a cabo las operaciones lógicas.
public class ClienteServiceImpl implements ClienteService{

    private EntityManager entityManager;
    private ClienteRepository repository;

    public ClienteServiceImpl(EntityManager entityManager){
        this.entityManager = entityManager;
        this.repository = new ClienteRepository(entityManager);
    }

    @Override
    public List<Cliente> listar() {
        return repository.listar();
    }

    @Override
    public Optional<Cliente> porId(int id) {
        return Optional.ofNullable(repository.porId(id));
    }

    @Override
    public void guardar(Cliente objeto) {

        try {
            entityManager.getTransaction().begin();
            repository.guardar(objeto);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void eliminar(int id) {

        try {
            entityManager.getTransaction().begin();
            repository.eliminar(id);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

    }

    @Override
    public void actualizar() {

        try {

            int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el id del cliente a modificar"));
            Cliente cliente = entityManager.find(Cliente.class, id);
            String nombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cliente");
            String apellido = JOptionPane.showInputDialog("Ingrese el nuevo apellido del cliente");
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);

            entityManager.getTransaction().begin();
            repository.actualizar(cliente);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

    }
}
