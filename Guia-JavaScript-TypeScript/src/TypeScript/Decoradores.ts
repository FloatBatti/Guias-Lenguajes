// Un decorador es una función que se utiliza para agregar metadatos a una clase, propiedad, método, parámetro o accesor de 
// una clase. Los decoradores se aplican utilizando la sintaxis "@nombre_del_decorador" justo encima del elemento que se 
// desea decorar. Se debe tener agregar la opción "experimentalDecorators" = true en el archivo tsconfig.json.

// Los decoradores en TypeScript se definen como funciones regulares que reciben uno, dos o tres argumentos, dependiendo del
// tipo de elemento que se esté decorando. El primer argumento siempre es el objeto de destino que se está decorando, 
// mientras que los argumentos adicionales varían según el tipo de decorador y el elemento que se esté decorando.

// Los decoradores pueden ser utilizados para realizar tareas como la validación de datos, la autenticación, el registro de
// estadísticas, el formateo de datos, la manipulación de eventos y mucho más.

// Decoradores de clase:

// Los decoradores de clase se aplican a la declaración de la clase y se ejecutan cuando se declara la clase. 
// Se ejecuta antes de que se cree la instancia de la clase.

// taget hace referencia a la clase que se esta decorando.
function DecoradorClase(target:Function){

    // Con prototype se puede agregar un método a la clase que se esta decorando.
    target.prototype.saludar = function():void{ // Se agrega un metodo saludar a la clase que se esta decorando.

        console.log("Hola");
    }

    target.prototype.apellido; // Se agrega un atributo apellido a la clase que se esta decorando.
}

@DecoradorClase
class MiClase{
    
        public nombre:string;
    
        constructor(nombre:string){
    
            this.nombre = nombre;
        }
}

let miClase = new MiClase("Juan");

// Las siguientes lineas muestran errores porque los decoradores son experimentales, en el navegador funciona bien:
/*

miClase.saludar();
miClase.apellido = "Perez";
console.log(miClase.apellido);

*/

  