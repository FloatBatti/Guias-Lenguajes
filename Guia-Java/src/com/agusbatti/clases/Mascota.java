package com.agusbatti.clases;

import java.util.Arrays;

public abstract class Mascota { // Siempre es una clase padre, representa un concepto.
                                // No se puede instanciar un objeto de esta clase (instanciar). Sirve para heredar.
                                // Cada clase hija se ve obligada va a sobreescribir los métodos abstractos para
                                // implementarlos de formas distintas. Puede tener métodos con cuerpo (no abstractos).
                                // Sirve para definir comportamientos comunes a las clases hijas.
                                // Se usa la palabra reservada abstract para declarar una clase abstracta.
                                // Una clase abstracta puede tener métodos abstractos y no abstractos.
                                // Una clase abstracta puede tener atributos y constructores.


    protected String nombre;
    protected String especie;
    protected String raza;
    protected String tamaño;
    protected String[] comidaFavorita;

    public Mascota() {
    }

    public Mascota(String nombre){
        this.nombre = nombre;
    }

    public Mascota(String nombre, String raza, String tamaño) {
        this.nombre = nombre;
        this.raza = raza;
        this.tamaño = tamaño;
        this.comidaFavorita = new String[5];
    }

    // region Getters and Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public String[] getComidaFavorita() {
        return comidaFavorita;
    }

    public void setComidaFavorita(String[] comidaFavorita) {
        this.comidaFavorita = comidaFavorita;
    }

    // endregion
    
    public void agregarComida(String comida) { // Puede haber métodos no abstractos. A veces todas las clases hijas
                                               // implementan los mismo

        for (int i = 0; i < this.comidaFavorita.length; i++) {

            if (this.comidaFavorita[i] == null) {

                this.comidaFavorita[i] = comida;
                break;
            }
        }

    }

    @Override
    public String toString() {
        return "Mascota [nombre=" + nombre + ", raza=" + raza + ", tamaño=" + tamaño
                + ", comidaFavorita=" + Arrays.toString(comidaFavorita) + "]";
    }


    abstract public void hacerRuido(); // Sea la clase hija que sea (perro, gato, caballo, ect) va a poder hacer ruido

    abstract public void dormir();

}
