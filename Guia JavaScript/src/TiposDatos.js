
var numero = 10; // Tipo de dato numérico
let numero2 = 20; // En JavaScript moderno se utiliza let en lugar de var.
const numero3 = 30; // Tipo de dato numérico constante. No se puede modificar su valor.

// Las variables pueden cambiar de tipo. A esto se le llama "tipado dinámico".
// El intérprete asigna a las variables un tipo durante el tiempo de ejecución basado en su 
// valor en ese momento.

numero = "Agustin"; // Tipo de dato string

console.log(numero); // Imprime "Agustin"

console.log(typeof numero); // typeof devuelve el tipo de dato de la variable, en este caso "string"

let boolean = true; // Tipo de dato booleano

console.log(boolean); // Imprime "true"

// Tipo de dato Symbol. Es un tipo de dato primitivo que se utiliza para generar valores únicos.
// El .for es para generar un símbolo que sea único en todo el programa. Si se genera un símbolo con el mismo nombre,
// se obtiene el mismo símbolo. Se recomienda usar .for paracrear un símbolo a partir de una cadena de texto,

let simbolo1 = Symbol("Soy un simbolo");
let simbolo2 = Symbol.for("Soy otro simbolo");
let simbolo3 = Symbol.for("Soy otro simbolo");

console.log(simbolo1); // Imprime "Symbol(simbolo)"
console.log(simbolo2); 
console.log(typeof simbolo1); // Imprime "symbol"

Symbol("Soy un simbolo") === Symbol("Soy un simbolo"); // Devuelve false. Cada símbolo es único.
simbolo2 === simbolo3; // Devuelve true. Se obtiene el mismo símbolo porque se uso el método .for.

// El método .keyFor devuelve la descripción de un sybol global hecho con .for. Si se le pasa un símbolo que no fue creado
// con .for, devuelve undefined. El método .description devuelve la descripción de un symbol sin importar si fue creado con
// .for o no.
console.log(simbolo1.description); // Imprime "Soy un simbolo". Devuelve la descripcion del lsímbolo.
console.log(Symbol.keyFor(simbolo2)); // Imprime "Soy otro simbolo". Devuelve la descripcion del símbolo.

// Tipo de dato undefined. Es un tipo de dato especial que indica que una variable no tiene valor 
// asignado.

let x;
console.log(x); // Imprime "undefined"

// Tipo de dato null. Es un tipo de dato especial que indica que una variable no tiene valor.
// null sirve para indicar que una variable no tiene valor, mientras que undefined indica que la variable no ha sido 
// declarada. Por ejemplo, si definimos una variable que espera un valor numérico, y no le asignamos ningún valor, su 
// valor será undefined. Si le asignamos el valor null, significa que la variable no tiene valor.
// Esto puede ocurrir cuendo esperamos algun valor de una API y no nos devuelve nada, arrojando un error por querer acceder 
// a un atributo de un objeto que no existe. En cambio, si le asignamos undefined a ese atributo, no se arroja ningún error.

let esperandoDato = undefined;
let y = null;
console.log(y); // Imprime "null"
console.log(typeof y); // Imprime "object". Se considera un error de diseño de lenguaje.

// ------------------------------------------------------------------------------------------------------------------

// Tipo de dato clase. Es un tipo de dato especial que se utiliza para generar objetos.
// El tipo de dato clase es una función.

class Persona {
    constructor(nombre, edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}

let agustin = new Persona("Agustin", 27); // Instancia de la clase Persona.

console.log(agustin); // Imprime el objeto completo.

// ------------------------------------------------------------------------------------------------------------------

let z = '';
console.log(z); // El valor de una variable string vacía es ""

let nombre = "Ana";
let apellido = "Pérez";

console.log(nombre + " " + apellido); // Concatenación de strings

 // Concatenación de strings con template literals. Los template literals son strings que permiten expresiones incrustadas.
 // Se definen con comillas invertidas (``) en lugar de comillas simples o dobles. Se pueden usar variables dentro de los 
 // template literals, y se pueden usar expresiones dentro de ${}.

console.log(`${nombre} ${apellido}`);

// Otro ejemplo de template literals

let a = 10;
let b = 20;

console.log(`La suma de ${a} + ${b} es ${a + b}`); // Imprime "La suma de 10 + 20 es 30"

let cadena = "Juan" + 2 + 4; 
console.log(cadena); // Imprime "Juan24". La concatenación de strings tiene prioridad sobre la suma.

let cadena2 = "Juan" + (2 + 4);
console.log(cadena2); // Imprime "Juan6". Se pueden usar paréntesis para cambiar la prioridad.

let cadena3 = 2 + 4 + "Juan";
console.log(cadena3); // Imprime "6Juan". Al hacer la suma primero, el resultado es un número.

// ------------------------------------------------------------------------------------------------------------------

const promedio = 5.9;

const resultado = promedio >= 6 ? "Aprobado" : "Desaprobado"; // Operador ternario. Si la condición es verdadera,
// devuelve el primer valor, si es falsa, devuelve el segundo valor.

console.log(resultado); // Imprime "Desaprobado".




