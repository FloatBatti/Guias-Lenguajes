// El arreglo solo puede contener el tipo de dato que se le indique en el generico.
let arregloNumeros:Array<number> = [1,2,3,4,5];

console.log(arregloNumeros);

// Ejemplo de clase generica:

class Cuadrado<T extends number|string>{ // Se indica que T puede ser de tipo number o string.

    base:T;
    altura:T;

    constructor(base:T, altura:T){
        this.base = base;
        this.altura = altura;
    }

    area():number{
        return +this.base * +this.altura; // El signo + convierte el string a number.
    }

}

let cuadrado1 = new Cuadrado<number>(2,2);

console.log(cuadrado1.area());

let cuadrado2 = new Cuadrado<string>("2","2");

console.log(cuadrado2.area());

