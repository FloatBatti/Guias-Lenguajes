package com.agusbatti.interfaces;

import java.util.List;

public interface IRepository<T> {
    
    List<T> listar();
    T devolverPorId(Integer id);
    void crear();
    void editar(Integer id);
    void eliminar();

}
