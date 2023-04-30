package com.agusbatti.clases;

public class Perro extends Mascota{

    public Perro(String nombre, String raza, String tamaño) {
        super(nombre, raza, tamaño);
    }

    public Perro(String nombre) {
        super(nombre);
    }

    public Perro(){}
    
    @Override
    public void hacerRuido() {
        System.out.println("El perro está ladrando");
    }

    @Override
    public void dormir() {
        System.out.println("El perro está duermiendo");
        
    }
    
}
