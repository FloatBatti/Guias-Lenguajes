package org.agusbatti.java.repositorio;

import java.util.List;

public interface Repositorio<T> {

    List<T> listar();
    T buscarPorId(int id);
    void guardar(T t);
    void eliminar(int id);
    void actualizar(T t);
}
