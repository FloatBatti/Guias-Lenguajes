// Tipo de dato clase. Es un tipo de dato especial que se utiliza para generar objetos.
// El tipo de dato clase es una función, pero proporciona una sintaxis más clara y concisa para la creación de objetos.
// A diferencia de las funciones, si se crea un objeto antes de la declaración de la clase, se produce un error.
// Todas las clases heredan de la clase Object.

class Persona {

    // Atributo static. Se puede acceder a él sin necesidad de crear una instancia de la clase.
    // Si se quiere acceder a un atributo static desde un objeto se interpretara que se agrega un nuevo atributo al objeto.
    static contadorPersonas = 0; 

    // Metodo static que devuelve un valor, tambien llamado constante estática.
    // Al ser un get y no un set, no se puede modificar el valor de la constante.
    static get MAX_OBJ() { return 5; } 

    _pais = "Argentina"; // Se pueden declarar atributos fuera del constructor. Se inicializan con el valor por defecto.

    constructor(nombre, edad) {

        // Se utiliza '_' como convención para indicar que el atributo es privado y que solo peuede accederse desde getters y setters.
        // Tambien se utiliza para que no se confunda con los nombres de los getters y setters.
        this._nombre = nombre;
        this._edad = edad;
        Persona.contadorPersonas++; // Se incrementa el contador de personas cada vez que se crea una nueva persona.
    }

    get nombre() { return this._nombre; } // Getter.

    set nombre(nombre) { this._nombre = nombre; } // Setter.

    get edad() { return this._edad; }

    set edad(edad) { this._edad = edad; } 

    get pais() { return this._pais; }

    set pais(pais) { this._pais = pais; }

    // No hace falta utilizar la palabra function para crear un metodo.
    datos() { return `${this._nombre}, ${this._edad} años de edad, nacionalidad ${this._pais}`; }

    // Se sobreescribe el metodo toString de la clase Object para queel objeto pueda imprimirse como un string.
    // Se utiliza toString() porque en la página web no se ve como en la consola (console.log()).
    // Cuando se utiliza el metodo toString() de un objeto, va a devolver lo que devuelva este metodo.
    toString() { return this.datos(); }

    // Metodo estatico. Solo se llama desde la clase, no desde una instancia de la clase.
    static saludar() { console.log("Saludos desde un método static"); } 
    
}

let persona = new Persona("Agustin", 27); // Instancia de la clase Persona.

console.log(persona); // Imprime el objeto completo.

console.log(persona.nombre); // Imprime "Agustin" utilizando el getter.

persona.nombre = "Juan"; // Modifica el valor del atributo nombre utilizando el setter. Es equivalente a persona.nombre("Juan").

console.log(persona.nombre); // Imprime "Juan".

console.log(persona.datos()); // Imprime "Juan, 27 años de edad".

console.log(persona.toString()); // Imprime "Juan, 27 años de edad".

Persona.saludar(); // Se llama al metodo static saludar().

// Se agrega/crea un atributo static a la clase Persona.
Persona.ciudad = "Buenos Aires"; // La clase hija Empleado tambien va a tener este atributo.

console.log(Persona.MAX_OBJ); // Imprime 5.

//! Herencia:

class Empleado extends Persona { // Se crea una clase Empleado que hereda de Persona.

    // El constructor se llama automaticamente cuando se crea una instancia de la clase.
    constructor(nombre, edad, sueldo) {

        super(nombre, edad); // Se llama al constructor de la clase padre.

        this._sueldo = sueldo;
    }

    get sueldo() { return this._sueldo; }

    set sueldo(sueldo) { this._sueldo = sueldo; }

    // Con la palabra reservada super se puede acceder a los metodos de la clase padre.
    // Si declaro un metodo con el mismo nombre que un metodo de la clase padre, se sobreescribe el metodo de la clase padre.
    datos() { return `${super.datos()}, sueldo: ${this._sueldo}`; } // Se llama al metodo datos de la clase padre.

    toString() { return this.datos(); }

}

let empleado = new Empleado("Tomás", 21, 1500);

console.log(empleado); // Imprime el objeto completo.

console.log(empleado.datos()); // Imprime "Juan, 27 años de edad".

console.log(empleado.toString()); // Imprime "Juan, 27 años de edad".

console.log(Persona.contadorPersonas); // Imprime 2.

console.log(Empleado.ciudad); // Imprime "Argentina".


class Gerente{

    constructor(nombre, edad, sueldo, departamento) {

        this._nombre = nombre;
        this._edad = edad;
        this._sueldo = sueldo;
        this._departamento = departamento;
    }

}

// La palabra reservada instanceof devuelve true si el objeto es una instancia de la clase.
if(empleado instanceof Empleado) { 
    console.log("Es una instancia de la clase Empleado");
}

if(empleado instanceof Persona){

    console.log("Al ser Empleado una clase hija de Persona, tambien es una instancia de Persona");
}

if(empleado instanceof Gerente){

    console.log("Es una instancia de la clase Gerente");
    
}else{

    console.log("No es una instancia de la clase Gerente");
}



