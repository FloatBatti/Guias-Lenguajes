// Tipo de dato function. Las funciones son un tipo de dato especial en JavaScript. 
// Se pueden asignar a variables y pasarlas como parámetros a otras funciones.

function miFuncion() { console.log("Hola"); }

miFuncion(); // Imprime "Hola"

// Existen también las funciones anónimas, que no tienen nombre. Se asignan a variables.
// Se utilizan para pasarlas como parámetros a otras funciones.

const miFuncion2 = function() { console.log("Hola de forma anónima"); }

miFuncion2(); 

// También se pueden definir funciones anónimas utilizando arrow functions, utilizando expresiones lambda.
const miFuncion3 = () => console.log("Hola de forma anónima con arrow function");

miFuncion3();

// Arrow function con parámetros. Devuelve la suma de los parámetros. Se pueden dar valores por defecto a los parámetros.
const add = (a = 0, b = 0) => a + b; 

console.log(add(2, 3)); // Imprime 5


// Funciones self-invoking:

// Son funciones que se invocan a sí mismas. Se definen entre paréntesis y se invocan inmediatamente. Los parámetros se 
// pasan entre los paréntesis de la función ubicados al final de esta.

(function(mensaje) {

    console.log(mensaje);

})("Hola desde una función self-invoking");


//! Funciones callback:

// Son funciones que se pasan como parámetros a otras funciones. Se utilizan mucho en JavaScript para ejecutar código asíncrono.
// Es una llamada a una función (pasada como parámetro) que se ejecuta cuando se termina de ejecutar la función que la recibio.

function miFuncion4(callback) {

    console.log("Hola desde miFuncion4");

    callback();
}

miFuncion4(function() { console.log("Hola desde la función callback"); });

function mostrarResultado(resultado) {

    console.log(resultado);
}

function sumar(a, b, callback) {

    let resultado = a + b;

    // Se llama a una función definida anteriormente.
    callback(resultado);
}


sumar(2, 3, mostrarResultado);

sumar(4,4, mostrarResultado);

//! Llamada asíncrona con setTimeout:

// setTimeout es una función que recibe como parámetro una función y un tiempo expresado en milisegundos.
// Un proceso sincrónico es aquel que se ejecuta en el mismo orden en el que se encuentra en el código. Asíncrono lo contrario.
// Las funciones asincronas nos permiten ejecutar código sin detener la ejecución del programa, es decir, en segundo plano.

setTimeout(() => console.log("Hola desde setTimeout") , 3000);

// Se ejecuta primero el console.log del código principal y luego el de setTimeout.
console.log("Hola desde el código principal");

//! Llamada asíncrona con setInterval:

// setInterval es una función que recibe como parámetro una función y un tiempo expresado en milisegundos.
// Ejecuta la función cada cierto tiempo indicado en el segundo parámetro.

let contador = 0;

let reloj = () => {

    let fecha = new Date();

    console.log(`${fecha.getHours()}:${fecha.getMinutes()}:${fecha.getSeconds()}`);

    contador++;

    if(contador == 5) {

        clearInterval(intervalo); // Detiene la ejecución de la función setInterval.
    }
}




