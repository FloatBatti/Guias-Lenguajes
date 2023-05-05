// Tipo de dato array. Es un tipo de dato especial que se utiliza para generar arreglos.

let autos = ["BMW", "Audi", "Chevrolet"];

console.log(typeof autos); // Imprime "object" porque los arrays son de tipo objeto.

console.log(autos[1]); // Imprime el segundo elemento del array.

autos.push("Ferrari"); // Agrega un elemento al final del array.
autos.unshift("Mercedes Benz"); // Agrega un elemento al principio del array.

console.log(autos); // Imprime el array.

autos.pop(); // Elimina el último elemento del array.
autos.shift(); // Elimina el primer elemento del array.

console.log(autos);

autos.splice(1, 1); // Elimina un elemento del array. El primer parámetro es el índice del elemento a eliminar, y el segundo
// parámetro es la cantidad de elementos a eliminar a partir del índice indicado.

console.log(autos);

const nuevosAutos = autos.concat("Fort"); // Agrega elementos al final del array. Devuelve una nueva instancia del array.
// Si no se asigna el resultado a una variable, los cambios se pierden, porque el método concat no modifica el original.

console.log(nuevosAutos);
console.log(autos);

// Formas de recorrer un array:

for (const auto of autos) {
  // Se usa const en lugar de let porque no se va a modificar el valor de la variable.

  console.log(auto);
}

for (let i = 0; i < autos.length; i++) {
  // El método length devuelve la cantidad de elementos del array.
  console.log(autos[i]);
}

autos.forEach((auto) => console.log(auto));

const notebooks = ["HP", "Lenovo", "Dell", "Asus"];

const productos = [...autos, ...notebooks, "MSI"]; // Crea un nuevo array con los elementos de los otros dos arrays.

console.log(productos);

// Desestructuración de arrays:

const [a, b, c] = productos; // Desestructura el array productos en tres variables. Lo hace en el orden en el que están.

console.log(a, b, c);

const [d, e, f, , , g] = productos; // Se pueden saltear elementos indicando un espacio vacío.

console.log(d, e, f, g);

const [h, , ...resto] = productos; // Con los tres puntos se toma el resto de los elementos, devolviendo un array.

console.log(h, resto);


