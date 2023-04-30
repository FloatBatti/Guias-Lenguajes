package com.agusbatti.anotaciones;

import java.time.LocalDate;

public class Producto {

    @Anotaciones(nombre = "Descripción del producto", capitalizar = true)
    private String descripcion;

    @Anotaciones
    private double precio;
    @Anotaciones(nombre = "Fecha de vencimiento")
    private LocalDate fechaDeVencimiento;

    public Producto(String nombre, double precio, LocalDate fechaDeVencimiento) {
        this.descripcion = nombre;
        this.precio = precio;
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    // region Getters y setters
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public LocalDate getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(LocalDate fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    // endregion

    @Anotaciones
    private void capitalizar(){

        this.descripcion = this.descripcion.substring(0,1).toUpperCase()
                + this.descripcion.substring(1).toLowerCase();
    }
}
