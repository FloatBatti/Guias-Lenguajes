// Tipo de dato objeto. Los objetos en JavaScript tienen mucha relación con los Json (JavaScript Object Notation). Esto es 
// porque las APIs o APIs REST siempre devuelven Json, y los objetos en JavaScript se pueden convertir a Json y viceversa.
// Se suelen utilizar como constante porque siempre esa variable va a guardar el mismo objeto. Aún asi, se pueden 
// modificar sus atributos. Tambien se pueden crear objetos, funciones y arreglos dentro de objetos.

const objeto = { 
    
    nombre: "Lucas", 
    apellido: "Garcia", 

    mascota: { 
        nombre: "Toby", 
        edad: 5 },

    items: [

        { id: 1, nombre: "item 1", price: 30 },
        { id: 2, nombre: "item 2", price: 50 },
        { id: 3, nombre: "item 3", price: 10 }
    ],

    total: function() {

        let total = 0;

        this.items.forEach(item => total += item.price);

        return total;
    },

    saludar: function() { 
        console.log(`Hola soy ${this.nombre}`); 
    }
};

console.log(objeto); // Imprime el objeto completo.
console.log(objeto.nombre); // Imprime "Lucas".

objeto.saludar(); // Imprime "Hola soy Lucas".
console.log(`El precio total de todos los items es: ${objeto.total()}`); // Imprime 90.

objeto.nombre = "Agustin"; // Modifica el valor del atributo nombre.
objeto.mascota.nombre = "Scooby"; // Modifica el valor del atributo nombre del objeto mascota.

const objeto2 = objeto; // Se crea una nueva variable que apunta al mismo objeto que objeto.

console.log(objeto == objeto2); // Compara en función de su referencia en memoria. Imprime true.
console.log(objeto === objeto2); // Compara función de su contenido y tipo de dato. Imprime true.

 // Con los tres puntos se crea un nuevo objeto en memoria, y se copian los atributos del objeto original.
 // Los parentesis indican que se está creando un objeto y con los 3 puntos se exparsen los atributos del objeto original.
const objeto3 = { ... objeto}; // A los tres puntos se les llama operador spread.

console.log(objeto == objeto3); // Imprime false.
console.log(objeto === objeto3); // Imprime false.

console.log(objeto.company); // Imprime undefined. No existe el atributo company en el objeto. No hay error.
console.log(objeto.company?.nombre); // Si no se escribe el signo de pregunta, se produce un error. Imprime undefined.

// Desestructuración de objetos (destructuring):

const { nombre, apellido } = objeto; // Se crea una variable nombre y apellido que apuntan a los atributos del objeto.

// Tiene que tener el mismo nombre que el atributo del objeto. Se puede cambiar el nombre de la variable con dos puntos.
const { nombre: objNombre, apellido: objApellido, mascota:{nombre: nombreMascota}} = objeto;

console.log(nombre); // Imprime "Agustin".
console.log(objApellido); // Imprime "Gracía".
console.log(nombreMascota); // Imprime "Scooby".

// Otro ejemplo: 

const user = {

    username: "admin",
    password: "1234",
    email: "admin@gmail.com"
}

const detallar = ({username, email}) => { // Se crea una función que recibe la desestructuración del objeto.

    console.log(`El usuario ${username} tiene el email ${email}`);

}

detallar(user); 