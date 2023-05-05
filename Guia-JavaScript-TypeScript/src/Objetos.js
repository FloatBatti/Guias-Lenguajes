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
    },

    get nombreCompleto() { // Se crea un getter para obtener el nombre completo del objeto.
        return `${this.nombre} ${this.apellido}`;
    },

    set nombreCompleto(nombreCompleto) { // Se crea un setter para modificar el nombre completo del objeto.
        const nombreYApellido = nombreCompleto.split(" ");
        this.nombre = nombreYApellido[0];
        this.apellido = nombreYApellido[1];
    }
};

console.log(objeto); // Imprime el objeto completo.
console.log(objeto.nombre); // Imprime "Lucas".
console.log(objeto["apellido"]); // Se puede acceder a los atributos con corchetes.

objeto.saludar(); // Imprime "Hola soy Lucas".
console.log(`El precio total de todos los items es: ${objeto.total()}`); // Imprime 90.

objeto.nombre = "Agustin"; // Modifica el valor del atributo nombre.
objeto.mascota.nombre = "Scooby"; // Modifica el valor del atributo nombre del objeto mascota.

const objeto2 = objeto; // Se crea una nueva variable que apunta al mismo objeto que objeto.

console.log(objeto.nombreCompleto); // Se llama al getter nombreCompleto.

objeto.nombreCompleto = "Juan Perez"; // Se llama al setter nombreCompleto y se le pasa el nombre completo.

console.log(objeto.nombreCompleto); // Imprime "Juan Perez".

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

const detallar = ({username, email}) => { // Se crea una función que recibe un objeto y se desestructuro.

    console.log(`El usuario ${username} tiene el email ${email}`);

}

detallar(user); 

let auto = new Object(); // Se reserva espacio en memoria para un objeto de manera explícita.

auto.marca = "Ford"; // Se crea el atributo marca y se le asigna el valor "Ford".
auto.modelo = "Focus"; 

// Recorrer las propiedades/atributos de un objeto:

for(let atributo in auto) {

    console.log("Nombre del atributo: " + atributo);
    console.log("Valor del atributo: " + auto[atributo]); 
}

auto.edad = 5; 

delete auto.edad; // Se elimina el atributo edad del objeto auto.

let autoArray = Object.values(auto); // Se crea un arreglo con los valores del objeto auto.

console.log(autoArray); // Imprime ["Ford", "Focus"].

// Se crea una función constructora de objetos. Se utiliza la palabra reservada this para referirse al objeto que se 
// está creando.
function Persona(nombre, apellido, edad) {

    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.saludar = function() { console.log(`Hola soy ${this.nombre}`); }
}

const persona1 = new Persona("Lucas", "Garcia", 20); // Se crea un objeto persona1 con la función constructora.

console.log(persona1); // Imprime el objeto persona1.

persona1.saludar(); // Imprime "Hola soy Lucas".

Persona.prototype.direccion = "Calle 123"; // Se agrega un atributo al prototipo de la función constructora.

console.log(persona1.direccion); // Imprime "Calle 123".

// Uso del método call() para llamar a una función de un objeto, pero con los datos de otro objeto:

const persona2 = {

    nombre: "Julio",
    apellido: "Fernandez",
    nombreCompleto: function(titulo, telefono) { return titulo + `: ${this.nombre} ${this.apellido}, ` + telefono; }
}

const persona3 = {

    nombre: "Juan",
    apellido: "Perez",
}

// Se llama a la función saludar del objeto persona1, pero con los datos del objeto persona2.
// Primero se pasa el objeto que se quiere utilizar, y luego los parámetros de la función.

console.log(persona2.nombreCompleto.call(persona3, "Programador", "2236065897")); 

// Uso del método apply(), similar al método call(), pero los parámetros se pasan en un arreglo:

let arreglo = ["Programador", "2236065897"];

console.log(persona2.nombreCompleto.apply(persona3, arreglo));

