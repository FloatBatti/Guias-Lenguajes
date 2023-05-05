package com.agusbatti.interfaces;

public class EjemploInterfazFuncional {
    
    public static void main(String[] args) {
        
        IFAritmetica suma = (a,b) -> a + b;
        IFAritmetica resta = (a,b) -> a - b;

        Calculadora calculadora = new Calculadora();

        System.out.println(calculadora.computar(5, 3, suma));
        System.out.println(calculadora.computar(5, 3, resta));
        System.out.println(calculadora.computar(5, 3, (a,b) -> a * b));



    }
}
