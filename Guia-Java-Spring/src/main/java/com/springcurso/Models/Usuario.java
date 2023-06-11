package com.springcurso.Models;

// Esta clase es de tipo POJO (Plain Old Java Object), es decir, es una clase que no hereda de ninguna otra clase.
public class Usuario {

    private String nombre;
    private String apellido;
    private String email;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // region Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // endregion
}
