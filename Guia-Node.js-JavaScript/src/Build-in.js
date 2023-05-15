// Un modulo build-in es un modulo que viene por defecto en nodejs.
// Algunos de los modulos build-in son:

// 1. path: Nos permite trabajar con las rutas de los archivos.
// 2. fs: Nos permite trabajar con el sistema de archivos de la computadora.
// 3. hhtp: Nos permite crear un servidor.
// 4. https: Nos permite crear un servidor seguro.
// 5. os: Nos permite trabajar con el sistema operativo.
// 6. console: Nos permite trabajar con la consola.
// 7. process: Nos permite trabajar con el proceso de nodejs.
// 8. timers: Nos permite trabajar con los temporizadores.

console.log("Muestra un mensaje en la terminal");
console.error("Muestra un mensaje de error en la terminal");
console.warn("Muestra un mensaje de advertencia en la terminal");
console.clear(); // Limpia la terminal.

/* Se comenta porque es mucho texto en consola.
console.log(process); // Muestra un objeto con informacion del proceso de nodejs.
console.log(process.argv); // Muestra un arreglo con los argumentos que se le pasan a nodejs por consola.
console.log(process.argv[2]); // Muestra el tercer argumento que se le pasa a nodejs por consola.
*/

// Con el modulo fs se puede leer y escribir archivos. Los métodos son asincronos por defecto, es decir, no bloquean
// el hilo principal del programa.
import { readFile } from "fs"; // Se importa el modulo fs.

// El primer parametro indica el archivo a aleer, el segundo parametro indica el formato de lectura y el tercer
// parametro es una funcion callback que se va a ejecutar cuando se termine la lectura.
readFile("texto.txt", "utf-8", (error, contenido) => {
  // Se lee el archivo texto.txt.

  if (error) {
    // Si hay un error se muestra en consola.
    console.error(error);
  } else {
    console.log(contenido); // Si no hay error se muestra el contenido del archivo.
  }
});


