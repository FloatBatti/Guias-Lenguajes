package com.guiahibernate.entity;

import jakarta.persistence.*;

@Entity // Esta anotación es para indicar que esta clase es una entidad. Una entidad es una clase que se va a mapear
// a una tabla en la base de datos.
@Table(name = "clientes") // Indica el nombre de la tabla en la base de datos.
public class Cliente {

    @Id // Indica que el atributo es una llave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el valor de la llave primaria se va a generar
    // automáticamente, en este caso, se va a generar de forma incremental.
    private int id;
    private String nombre;
    private String apellido;
    @Column(name = "forma_pago") // Indica el nombre de la columna en la base de datos porque el nombre del atributo
    // no es igual al nombre de la columna en la base de datos.
    private String formaPago;

    // region Getters y setters
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    // endregion

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", formaPago='" + formaPago + '\'' +
                '}';
    }
}
