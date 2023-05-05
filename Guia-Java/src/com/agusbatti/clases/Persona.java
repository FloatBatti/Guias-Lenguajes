package com.agusbatti.clases;

import java.util.Arrays;
import java.util.Objects;

public class Persona implements Comparable<Persona> {

    // region Attributes
    
    protected Integer id;

    protected String nombre; // La clase hija va a poder utilizar el atributo con "this"
    protected String apellido;
    protected String dni;
    protected String ciudad;
    private String[] mascotas; // La clase hija solo va a poder acceder al atributo a travez de un getter o
                               // setter.

    public static final String PAIS = "Argentina"; // Con Final no se puede modificar, es una constante. Suele ser
                                                   // estática, pública y se pone en mayúscula.
    // endregion

    // region Constructors

    public Persona(String nombre, String apellido, String dni, String ciudad, int cantMascotas) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.ciudad = ciudad;
        this.mascotas = new String[cantMascotas];
    }

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }


    public Persona(){}

    // endregion

    // region Getters and Setters
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String[] getMascotas() {
        return mascotas;
    }

    public void setMascotas(String[] mascotas) {
        this.mascotas = mascotas;
    }

    // endregion

    @Override
    public String toString() {
        return "Nombre: " + this.nombre + " - " +
                "Apellido: " + this.apellido + " - " +
                "Dni: " + this.dni + " - " +
                "Ciudad: " + this.ciudad + " - " +
                "Mascotas:" + Arrays.toString(this.mascotas) + "\n";
    }

    @Override
    public int compareTo(Persona o) {

        return this.dni.compareTo(o.dni) * -1;
    }

    // endregion

    public void saludar() {
        System.out.println("Hola soy una persona");
    }

    public static void despedirse() { // Puedo tener métodos estáticos en una clase. No se puede acceder a los
                                      // atributos de la clase, solo a los parámetros del método.
        System.out.println("Chau");
    }

    public final Persona addMascota(final String mascota) { // Al poner final indico que no puede sobreescribirse en las
                                                      // clases hijas
        for (int i = 0; i < this.mascotas.length; i++) {

            if (this.mascotas[i] == null) {

                this.mascotas[i] = mascota;
                break;
            }
        }

        return this; // Permite concatenar el método
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona persona)) return false;
        return Objects.equals(id, persona.id) && Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dni);
    }
}
