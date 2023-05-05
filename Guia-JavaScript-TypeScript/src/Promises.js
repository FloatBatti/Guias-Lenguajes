// Una promesa es un objeto que representa la terminación o el fracaso de una operación asíncrona.
// Es un código que puede tener varios estados: pendiente (pending), cumplido (resolved) o rechazado(rejected).
// Al ser una operación asíncrona, el código se ejecuta en segundo plano y no bloquea la ejecución del programa.
// El constructor Promise recibe como parámetro una función con dos parámetros: resolve y reject.
// A su vez, la función que recibe como parámetro el constructor Promise recibe como parámetro una función con dos parámetros: resolve 
// y reject.

let promesa = new Promise((resolve, reject)=>{

    //let condicion = false;
    let condicion = true;

    if(condicion){
            
        resolve("Se resolvió correctamente");

    }else{

        reject("Ocurrió un error");
    }
});

// El método then() recibe una función como parámetro para el caso resuelto.
// El parametro de la función que recibe el método then() es el valor que se pasa como parámetro a la función resolve().
promesa.then(exito => console.log(exito));

// El método catch() recibe una función como parámetro para el caso de error.
// El parametro de la función que recibe el método catch() es el valor que se pasa como parámetro a la función reject().
promesa.catch(error => console.log(error));

// Normalmente se va a encontrar de la siguiente menra:

promesa.then(resolve => console.log(resolve)).catch(error => console.log(error));

// Utilizando setTimeout con promesas:

let promesa2 = new Promise((resolve) => {

    console.log("Inicio de la promesa");
    setTimeout(() => resolve("Saludos con promesa y timeout"), 3000);
    console.log("Fin de la promesa");
});

// Utilizando then porque no hay posibilidad de error.
promesa2.then(resolve => console.log(resolve));

// Utilizando async con promesas:

// async indica que una función regresa una promesa. 
async function miFuncionConPromesa(){

    // Es como si se estaria usando resolve().
    return "Saludos con promesa y async"; // Va a ser el parametro de la función que recibe el método then().
}

miFuncionConPromesa().then(valor => console.log(valor));

// Utilizando async y await con promesas:

// await solo se puede usar dentro de una función declarada con async.

async function funcionConPromesaYAwait(){
    
        let miPromesa = new Promise(resolve => {
    
            resolve("Promesa con await");
        });
    
        // await manda a llamar a la promesa y espera a que se resuelva.
        // Una vez que se resuelve, se retorna el valor para ser procesado por la función.
        console.log(await miPromesa);
}

funcionConPromesaYAwait();

async function funcionConPromesaAwaitTimeout(){

    let miPromesa = new Promise(resolve => {

        setTimeout(() => resolve("Promesa con await y timeout"), 3000);
    });

    console.log(await miPromesa);

    console.log("Fin de la función"); // No se va a ejecutar hasta que se resuelva la promesa.
}

funcionConPromesaAwaitTimeout();