package com.agusbatti.clases;

public class Gato extends Mascota {

    public Gato(String nombre, String raza, String tamaño) {
        super(nombre, raza, tamaño);
    }

    public Gato(){}

    @Override
    public void hacerRuido() {
        System.out.println("El gato está maullando");  
    }

    @Override
    public void dormir() {
        System.out.println("El gato está duermiendo");
        
    }
    
}
