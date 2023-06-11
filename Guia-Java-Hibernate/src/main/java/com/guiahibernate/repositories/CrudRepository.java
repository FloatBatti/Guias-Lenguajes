package com.guiahibernate.repositories;

import java.util.List;

public interface CrudRepository<T> {

    List<T> listar();
    T porId(int id);
    void guardar(T objeto);
    void eliminar(int id);
    void actualizar(T objeto);

}
