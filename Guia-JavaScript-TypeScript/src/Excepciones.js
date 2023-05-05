"use strict"

try {

    x = 10;
} catch (error) {

    console.log(error);
}finally{

    console.log("Se ejecuta siempre al finalizar el bloque try-catch");
}

console.log("Continua la ejecución del programa");

try {
    
    // Con la palabra reservada throw se puede lanzar una excepción.
    throw "Error personalizado";

} catch (error) {
    
    console.log(error);
}


try {

    x = 5;
    
} catch (error) {
    
    // Se puede obtener el nombre y el mensaje de la excepción con los atributos name y message.

    console.log(error.name);
    console.log(error.message);
}
