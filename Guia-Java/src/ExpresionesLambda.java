
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.agusbatti.clases.Gato;
import com.agusbatti.clases.Mascota;
import com.agusbatti.clases.Perro;


public class ExpresionesLambda {  // Una expresion lambda es una funcion anonima, ya que no tienen nombre.
                                  // No es contenida por ninguna clase.
                                  // Se conoce como método de flecha.
                                  // Su uso más importante es en los streams.
                                  // Se conoce como programación funcional si se usan funciónes lambda.

    public static void main(String[] args) {

        // Todas las siguientes interfaces ( Consumer, Supplier, Function y Predicate) se llaman funcionales, ya que solo
        // tienen un único método abstracto.

        //region CONSUMER
        
        // Consumer es una expresion lambda que recibe un parametro y no retorna nada.
        // El tipo de dato del parametro se puede omitir.
        // Si el cuerpo de la expresion lambda es una sola linea, se puede omitir las llaves.
        // Es un "consumer" porque consume un valor, pero no retorna nada.
        // Consumer es una interfaz funcional, ya que solo tiene un método abstracto.
        // Consumer solo acepta un parámetro, pero se puede usar una expresion lambda con varios parámetros.

        Consumer<String> consumidor = (String valor) -> System.out.println(valor);

        consumidor.accept("Hola mundo");  // Se ejecuta la expresion lambda. 
                                            // accept es el único método de la interfaz funcional.


        // BiConsumer es una expresion lambda que recibe dos parametros y no retorna nada.

        BiConsumer<String, Integer> consumidorBi = (nombre,edad) -> {  // Puedo evitar especificar el tipo de dato 
                                                                       //de los parámetros.
            
            System.out.println(nombre + " tiene " + edad + " años");};

        consumidorBi.accept("Juan", 25);

        Consumer<String> consumidor2 = System.out::println; // Se hace referencia a un método. 
        
        consumidor2.accept("Referencia al método System.out.println()");

        //endregion

        //region MÁS EJEMPLOS DE CONSUMER

        List<String> lista = Arrays.asList("Juan", "Pedro", "Maria", "Luis", "Ana");

        lista.forEach(consumidor);  // forEach es un método de la clase List que recibe un Consumer.
                                    // forEach recorre la lista y ejecuta el Consumer para cada elemento.
        
        lista.forEach(consumidor2); 

        Mascota mascota = new Perro();

        BiConsumer<Mascota, String> asignarNombre = (peronsa, nombre) -> peronsa.setNombre(nombre);

        asignarNombre.accept(mascota, "Firulais");

        System.out.println("Nombre de la mascota: " + mascota.getNombre());

        // Otra forma de hacer lo mismo de manera mas corta:

        BiConsumer<Mascota, String> asignarNombre2 = Mascota::setNombre;  // Se hace referencia al método set.
                                                                          // Se toma el orden de los parámetros
                                                                          // como está definido en los genéricos.

        asignarNombre2.accept(mascota, "Scooby");

        System.out.println("Se cambia el nombre de la mascota a " + mascota.getNombre());

        //endregion

        //region SUPPLIER

        // Supplier es una expresion lambda que no recibe parametros y retorna un valor.

        Supplier<String> proveedor = () -> "Hola mundo";  // Si es una sola linea se puede evitar el "return".

        System.out.println(proveedor.get());  // Se ejecuta la expresion lambda. 
                                              // get es el único método de la interfaz funcional.

        // Otras dos maneras de instanciar un objeto:

        Supplier<Mascota> crearGato = ()-> new Gato();  // Se puede usar una expresion lambda para crear un objeto.
        Supplier<Mascota> crearGato2 = Gato::new;       // Se hace referencia al constructor.

        Mascota mascota2 = crearGato.get();
        Mascota mascota3 = crearGato2.get();


        //endregion

        //region FUNCTION

        //Function es una expresion lambda que recibe un parametro y retorna un valor.

        Function<String, Integer> funcionLength = (String valor) -> {  // El primer generico es el tipo de dato
                                                                       // del parámetro y el segundo es el tipo
                                                                       // de dato del valor que retorna.
            return valor.length();};

        
        // Se utiliza el método apply para ejecutar la expresion lambda.
        System.out.println("La longitud de la palabra 'Hola' es: " + funcionLength.apply("Hola"));

        Function<String, String> funcionMayusculas = String::toUpperCase;  // Se hace referencia al método toUpperCase.
                                                                           // El primer genérico es el objeto sobre
                                                                           // el que se ejecuta el método y el segundo
                                                                           // es el que retorna.
        
        System.out.println("'Hola mundo' en mayúsculas: " + funcionMayusculas.apply("Hola mundo"));

        // Los primeros dos parámetros de la interfaz son los parámetros de la expresion y el último es el valor retornado.

        BiFunction <String, Integer, String> funcionSub = String::substring;  // Se hace referencia al método substring.
                                                                              // El primer genérico es el objeto sobre
                                                                              // el que se ejecuta el método, el segundo
                                                                              // es el que se pasa como parámetro en el 
                                                                              // método y el tercero es el que retorna.

                                                                             
        System.out.println("La subcadena de 'Hola mundo' desde la posición 2 es: " + funcionSub.apply("Hola mundo", 2));

        BiFunction <Integer, Integer, Integer> funcionSuma = (a,b) -> a + b;  // No hace falta poner return ya que es una
                                                                              // sola linea.

        System.out.println("La suma de 2 y 3 es: " + funcionSuma.apply(2, 3));

        //endregion
    
        //region PREDICATE

        // Predicate es una expresion lambda que recibe un parametro y retorna un booleano.
        // No se indica el tipo de dato del retorno ya que siempre retorna un booleano.
        // String::isEmpty es una como escribir (String valor) -> valor.isEmpty().

        Predicate<String> estaVacio = String::isEmpty;

        // Se utiliza el método test para ejecutar la expresion lambda.
        System.out.println("La palabra 'Hola' es vacía: " + estaVacio.test("Hola")); 

        BiPredicate<String, String> sonIguales = String::equals;

        System.out.println("Las palabras 'Hola' y 'Hola' son iguales: " + sonIguales.test("Hola", "Hola"));
                                                                           
        //endregion
    

    }
    


}
