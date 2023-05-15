// En el import se le asigna un nombre a la variable que se está importando por defecto. Solo se puede una por 
// archivo. Con ./ se indica que el archivo se encuentra en la misma carpeta que el archivo que lo importa.
// Entre los corchetes se indica el nombre de la variable que se está importando.
import saludosClientes, { clientes } from "./Clientes.js";

//! Uso del método map:

// Sevuelve un nuevo array con los elementos modificados, sin modificar el original.
const nombres = clientes.map((cliente) => {

    return cliente.nombre;
});

console.log(nombres);

const totalItems = clientes.map((cliente) => {

    return cliente.items.map((item) => { return item.producto;});
});

console.log(totalItems);

//! Uso del método find:

// find devuelve el primer elemento que cumpla con la condición indicada en la función.
const cliente = clientes.find((cliente) => {

    return cliente.id === 2;
});

console.log(cliente);

//! Uso del método filter:

// filter devuelve un nuevo array con los elementos que cumplan con la condición indicada en la función predicate.
const mayores = clientes.filter((cliente) => {

    return cliente.edad >= 30;

}).map((cliente) => { return cliente.nombre;});

console.log(mayores);

const comproMouse = clientes.filter((cliente) => {

    return cliente.items.find((item) => { return item.producto === "Mouse";});
    
}).map((cliente) => { return cliente.nombre;})

console.log(comproMouse);

// En el siguiente bloque de código  se utiliza el método "find" dos veces, una vez para buscar el cliente que tiene el 
// producto buscado dentro de "items", y otra vez para encontrar el objeto dentro de "items" que corresponde al producto 
// buscado. El método "find" recorre el arreglo de clientes y de items hasta encontrar el objeto que cumple con la condición
// dada.

const teclado = clientes.find(cliente => {

  return cliente.items.find(item => { return item.producto === "Teclado";});

}).items.find(item => {return item.producto === "Teclado";});

console.log(teclado);

// includes devuelve true si el elemento buscado se encuentra en el array, y false si no se encuentra.
const comproTeclado = clientes.filter((cliente) => cliente.items.includes(teclado));

console.log(comproTeclado);

// some devuelve true si al menos un elemento cumple con la condición indicada en la función predicate.
const result = clientes.some((cliente) => cliente.nombre === "Kevin");

console.log(result);

const saludos = saludosClientes(clientes);

console.log(saludos);

// Otra forma de incluir las variables, funciones, clases, etc. que se quieren exportar es la siguiente:
// con as se le asigna un nombre a la variable, función, clase, etc. que se está exportando.

export{

    nombres,
    totalItems,
    cliente,
    mayores as mayoresDeTreinta,
}