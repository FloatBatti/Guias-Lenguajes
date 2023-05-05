import { Accion } from "./Interfaces";

class Persona implements Accion{

    // con private se puede acceder a la variable solo dentro de la clase.
    private nombre:string;


    constructor(nombre:string){        
        this.nombre = nombre;
    }

    // Se implementan los metodos de la interfaz.
    saludar(): void {
        console.log("Hola");
    }
    
    trabajar(): void {
        console.log("Trabajando");
    }

    // El tipo de dato de retorno se define despues de los parentesis.
    public getNombre():string{
        return this.nombre;
    }

    static metodoEstatico():string{
        return "Soy un metodo estático";
    }
}

let persona1 = new Persona("Juan");
console.log(persona1.getNombre());

console.log(Persona.metodoEstatico());