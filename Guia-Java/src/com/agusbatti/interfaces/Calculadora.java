package com.agusbatti.interfaces;

public class Calculadora {
    
    
    public double computar(double a, double b, IFAritmetica lambda) {
        
        return lambda.operacion(a, b);
    }
}
