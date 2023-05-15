// Tipo de dato array. Es un tipo de dato especial que se utiliza para generar arreglos.

/*

Hay tres tipos de métodos en los areglos:

1. Mutadores: Modifican el array original.
2. Accesores: No modifican el array original, sino que devuelven una instancia del array modificado.
3. Iteradores: Iteran el arreglo y ejectuan una función por cada elemento (ver en MapFilerFind.js).

*/


let autos = ["BMW", "Audi", "Chevrolet"];

console.log(typeof autos); // Imprime "object" porque los arrays son de tipo objeto.

console.log(autos[1]); // Imprime el segundo elemento del array.

console.log(autos.length); // Imprime la cantidad de elementos del array.

console.log(autos.indexOf("BMW")); // Imprime el índice del elemento indicado.

//! Métodos mutadores:

autos.push("Ferrari"); // Agrega un elemento al final del array.
autos.unshift("Mercedes Benz"); // Agrega un elemento al principio del array.

console.log(autos);

autos.pop(); // Elimina el último elemento del array.
autos.shift(); // Elimina el primer elemento del array.

console.log(autos);

console.log(autos.sort()); // Ordena los elementos del array alfabéticamente.

console.log(autos.reverse()); // Invierte el orden de los elementos del array.

autos.splice(1, 2); // Elimina un elemento del array. El primer parámetro es el índice del elemento a eliminar, y el segundo
// parámetro es la cantidad de elementos a eliminar a partir del índice indicado.

console.log(autos);

autos.push("Audi", "BMW", "Chevrolet"); // Se pueden agregar varios elementos a la vez.

//! Métodos accesores:

let cadena = autos.join(" - "); // Convierte el array en una cadena de texto, separando los elementos con el caracter indicado.
console.log(cadena);

let arreglo = autos.slice(1, 3); // Devuelve un nuevo array con los elementos indicados. El primer parámetro es el índice 
// del primer elemento a devolver, y el segundo parámetro es el índice del último elemento a devolver. El elemento del
// segundo parámetro no se incluye en el nuevo array.
console.log(arreglo);

const nuevosAutos = autos.concat("Fort"); // Agrega elementos al final del array.

console.log(nuevosAutos);


//! Formas de recorrer un array:

for (const auto of autos) { // Con of se obtiene el valor de cada elemento del array.
  // Se usa const en lugar de let porque no se va a modificar el valor de la variable.
  console.log(auto);
}

for (const auto in autos) { // Con in se obtiene el índice de cada elemento del array.
  console.log(auto);
}

for (let i = 0; i < autos.length; i++) {
  // El método length devuelve la cantidad de elementos del array.
  console.log(autos[i]);
}

autos.forEach((auto) => console.log(auto)); //! forEach es un método iterador.

const notebooks = ["HP", "Lenovo", "Dell", "Asus"];

const productos = [...autos, ...notebooks, "MSI"]; // Crea un nuevo array con los elementos de los otros dos arrays.

console.log(productos);

//! Desestructuración de arrays:

const [a, b, c] = productos; // Desestructura el array productos en tres variables. Lo hace en el orden en el que están.

console.log(a, b, c);

const [d, e, f, , , g] = productos; // Se pueden saltear elementos indicando un espacio vacío.

console.log(d, e, f, g);

const [h, , ...resto] = productos; // Con los tres puntos se toma el resto de los elementos, devolviendo un array.

console.log(h, resto);


