package com.guiahibernate.services;

import com.guiahibernate.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> listar();
    Optional<Cliente> porId(int id);
    void guardar(Cliente objeto);
    void eliminar(int id);
    void actualizar();
}
