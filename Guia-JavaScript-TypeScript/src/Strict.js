"use strict" // Alponer esto, no se puede utilizar una variable sin declararla previamente.

// Si se pone lo siguiente, se produce un error porque no se declaró la variable x.
//x = 10;

// Manera correcta de declarar una variable.
let x = 10;

console.log(x);

function miFuncion(){

    // Si se utiliza el modo estricto en una función solo va a funcionar en esa función.
    "use strict"

    let y = 15;
    console.log(y);
}