// La consola sirve para mostrar información en la consola del navegador que nos puede ayudar a depurar nuestro código.
// Hay varios métodos para mostrar información en la consola:

console.group("Métodos de registro en consola"); //! Método de agrupación. Crea un nuevo grupo en la consola.

//! Métodos de registro:

console.log("Hola"); // Muestra información en la consola.

console.error("Error"); // Muestra un error en la consola.

console.assert(1 === 2, "1 no es igual a 2"); // Muestra un mensaje de error en la consola si la afirmación es falsa.

console.warn("Advertencia"); // Muestra una advertencia en la consola.

console.info("Información"); // Muestra información en la consola.

console.table(["cero", "uno", "dos", "tres", "cuatro"]); // Muestra una tabla en la consola.

console.table({ nombre: "Juan", apellido: "García", edad: 25 });

console.dir(document.body); // Muestra una lista de las propiedades del elemento en la consola.

//? console.clear() // Limpia la consola.

console.groupEnd(); //! Método de agrupación. Cierra el grupo en la consola para que no se creen subgrupos.

//! Métodos de conteo:

console.groupCollapsed("Métodos de conteo"); // groupCollapsed() es igual que group() pero el grupo aparece colapsado.

console.count(); // Muestra el número de veces que se ha ejecutado esa línea de código en la consola.
console.count(); 
console.count();
console.count(); 

console.countReset(); // Reinicia el contador de la línea de código en la consola.
console.count(); 

console.groupEnd();

//! Métodos de temporización:

console.groupCollapsed("Métodos de temporización");

console.time(); // Inicia un temporizador en la consola.

console.timeLog(); // Muestra el tiempo transcurrido desde que se inició el temporizador en la consola.

console.timeEnd(); // Detiene el temporizador en la consola.

console.groupEnd();





