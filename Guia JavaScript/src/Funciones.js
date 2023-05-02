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