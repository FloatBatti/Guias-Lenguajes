let cadena = "Cadena de prueba";
let cadena2 = "Cadena 2";

// concat() concatena dos o más cadenas.
console.log(cadena.concat(" - ").concat(cadena2));

// startsWith() comprueba si la cadena comienza con los caracteres de una cadena especificada.
console.log(cadena.startsWith("Cadena"));

// endsWith() comprueba si la cadena termina con los caracteres de una cadena especificada.
console.log(cadena.endsWith("pruebba"));

// includes() comprueba si la cadena contiene los caracteres de una cadena especificada.
console.log(cadena.includes("de"));

// indexOf() devuelve el índice, dentro del objeto String que realiza la llamada, de la primera ocurrencia del
// valor especificado, o -1 si no se encuentra dicho valor.
console.log(cadena.indexOf("de"));

// lastIndexOf() devuelve el índice, dentro del objeto String que realiza la llamada, de la última ocurrencia del
// valor especificado, o -1 si no se encuentra dicho valor.
console.log(cadena.lastIndexOf("de"));

// repeat() devuelve una cadena con un número específico de copias del texto de una cadena dada.
console.log(cadena.concat(" ").repeat(3));

// replace() devuelve una nueva cadena reemplazando el primer valor especificado por el segundo. El primer parámetro
// busca la primera coincidencia de la cadena a buscar.
console.log(cadena.replace("prueba", "test"));

// padStart() rellena la cadena actual con una cadena dada (repetida, si es necesario) de modo que la cadena resultante
// alcance una longitud dada. El relleno es aplicado desde el inicio (izquierda) de la cadena actual.
console.log(cadena.padStart(30, ":) "));

// padEnd() rellena la cadena actual con una cadena dada (repetida, si es necesario) de modo que la cadena resultante
// alcance una longitud dada. El relleno es aplicado desde el final (derecha) de la cadena actual.
console.log(cadena.padEnd(30, " :)"));

// split() divide un objeto de tipo String en un array de cadenas. Se debe especificar el separador.
console.log(cadena.split(" "));

// substring() devuelve un subconjunto de una cadena entre uno y otro índice, o hasta el final de la cadena.
// El primer índice se incluye, mientras que el segundo índice se excluye.
console.log(cadena.substring(0, 6));

// toLowerCase() devuelve el valor en minúsculas de la cadena que realiza la llamada.
console.log(cadena.toLowerCase());

// toUpperCase() devuelve el valor en mayúsculas de la cadena que realiza la llamada.
console.log(cadena.toUpperCase());

// trim() elimina los espacios en blanco en ambos extremos del string. Los espacios en blanco en este contexto,
// son todos los caracteres sin contenido (espacio, tabulación, etc.) y todos aquellos caracteres de control de
// línea (LF, CR, etc.). No afecta a los espacios entre palabras.
console.log("              Cadena 2  ".trim());

// trimStart() elimina los espacios en blanco al inicio del string.
console.log("              Cadena 2 ".trimStart());

// trimEnd() elimina los espacios en blanco al final del string.
console.log(" Cadena 2      ".trimEnd());


