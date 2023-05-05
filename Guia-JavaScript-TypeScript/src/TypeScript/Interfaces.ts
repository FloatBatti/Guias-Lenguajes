interface Usuario{ // Una interfaz es un contrato que se debe cumplir.

    // Se indica que la variable que implemente esta interfaz debe tener una variable nombre de tipo string.
    nombre:string;
    password:string;
    confirmarPassword?:string; // El signo de interrogacion indica que es opcional.
}

// Se crea una variable Usuario que implementa la interfaz Usuario, respetando el contrato.
let usuario1:Usuario = { 

    nombre: "Juan",
    password: "1234",
    confirmarPassword: "1234"
}

console.log(usuario1);

export interface Accion{

    saludar():void;
    trabajar():void;
}