package com.agusbatti.interfaces;

public interface ITrabajo { // Es como una clase abstracta pero no permite que algun método esté implementado.
                            // Captura similitudes entre clases no relacionadas sin forzar una relación entre ellas.
                            // Definen comportamientos que una o mas clases van a utilizar.
                            // Permiten "heredar" más de una clase. Se pueden implementar interfaces ilimitadas.
                            // Los métodos no llevan el modificador "abstract", ya que todos son abstractos.
                            // Como todos sus métodos son abstractos las clases hijas se veran 
                            // obligadas a implementarlos a todos.
                            // Las interfaces pueden heredar de otras interfaces con "extends".
                            // Una interfaz funcional es una interfaz que solo tiene un método abstracto.
                            // Las interfaces funcionales se pueden usar con expresiones lambda.
                            // Si es una interfaz funcional se debe indicar con la anotación @FunctionalInterface.

    
    void entrada();

    void trabajar();

    void tomarBreak();

    void irBaño();

    void salida();

    default void deafult(){  // El modificador default nos permite darle una implementación a un método.
                             // Este método lo van a tener por default las clases que implementen la interface.

        System.out.println("Soy un método default");
    }

}
