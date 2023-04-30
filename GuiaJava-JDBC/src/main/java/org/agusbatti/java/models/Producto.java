package org.agusbatti.java.models;

import java.util.Date;

public class Producto {

    private int id;
    private String nombre;

    private double precio;

    private Date fechaRegistro;

    private Categoria categoria;

    public Producto() {
    }

    public Producto(int id, String nombre, double precio, Date fechaRegistro) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }

    //region Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    //endregion

    @Override
    public String toString() {
        return  id +
                " | " +
                nombre +
                " | " +
                precio +
                " | " +
                fechaRegistro +
                " | " +
                categoria.getNombre();

    }
}
