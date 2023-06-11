package com.guiahibernate.DTO;

// DTO significa Data Transfer Object.
// Una clase DTO es una clase que se utiliza para transferir datos entre diferentes capas de la aplicación.
// Por un lado, tendríamos las clases entidad, que son las que se mapean a las tablas de la base de datos y por otro
// lado, tendríamos las clases DTO, que son las que se utilizan para transferir datos entre las capas de la aplicación.
public class ClienteDTO {

    String nombre;
    String apellido;

    public ClienteDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

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

    @Override
    public String toString() {
        return "ClienteDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}
