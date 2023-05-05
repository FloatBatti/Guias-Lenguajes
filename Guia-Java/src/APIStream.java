import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.agusbatti.clases.Perro;
import com.agusbatti.clases.Persona;

public class APIStream {

    public static void main(String[] args) {

        //region STREAMS

        // Un Stream es una secuencia de elementos que soporta operaciones de agregado.
        // Combina las mejores ideas del Iterator y la programación funcional.
        // No sirven para almacenar datos, solo para procesarlos.
        // Se pueden crear streams a partir de colecciones, arrays o métodos.
        // Para procesar los datos de un stream se utilizan operadores. Estos operadores se pueden encadenar.
        // Los operadores se dividen en intermedios y terminales.
        // Los métodos intermedios devuelven un nuevo stream.
        // Los métodos terminales devuelven un valor o void.
        // Los métodos intermedios no se ejecutan hasta que no se invoca un método terminal.
        // Los métodos terminales cierran el stream.
        // Los métodos terminales no se pueden encadenar con otros métodos.
        // Los métodos terminales no se pueden invocar más de una vez.
        // Los métodos terminales no se pueden invocar sobre un stream que ya fue cerrado.
        // Un método terminal es por ejemplo forEach(), collect(), count(), reduce(), min(), max(), etc.
        // Un método intermedio es por ejemplo map(), filter(), peek(), etc.
        // Los métodos terminales son obligatorios para procesar los datos de un stream.
        // No se puede reutilizar un stream una vez que se invoca un método terminal.
        // Los streams son inmutables, no se pueden modificar.

        // forEach() es un método terminal que recibe un Consumer como parámetro. No modifica el stream, solo lo recorre
        // y ejecuta el Consumer para cada elemento.
        
        // Stream.of() crea un stream a partir de una colección de elementos.
        Stream<String> stream = Stream.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J");

        stream.forEach(System.out::println);

        System.out.println("------------------------");

        String [] array = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        // Arrays.stream() crea un stream a partir de un array.
        stream = Arrays.stream(array);

        // Builder es una clase interna de Stream que permite crear un stream a partir de un método.
        // Se utiliza para crear streams de forma dinámica.
        // Se utiliza el método add() para agregar elementos al stream.
        // Se utiliza el método build() para crear el stream.
        Stream<String> nombres = Stream.<String>builder()
                                                            .add("Agustin")
                                                            .add("Daniel")
                                                            .add("Gonzalo")
                                                            .add("Marcelo").build();

        nombres.forEach(System.out::println);

        System.out.println("------------------------");

        List<String> perros = new ArrayList<>();

        perros.add("Scooby");
        perros.add("Pluto");
        perros.add("Firulais");
        perros.add("Snoopy");
        
        // List.stream() crea un stream a partir de una lista.
        Stream<String> perrosStream = perros.stream();

        perrosStream.forEach(System.out::println);

        System.out.println("------------------------");

        //endregion

        //region OPERADOR MAP

        // El operador map() permite transformar cada elemento del stream, utiliza la interface Function.
        // Se utiliza para aplicar una función a cada elemento del stream.
        // Retorna un nuevo stream con los elementos transformados.

        // Se diferencia del operador forEach() porque este no transforma los elementos, solo ejecuta operaciones
        // sobre cada elemento del stream.
        
        // El operador peek() permite inspeccionar los elementos de un stream, utiliza la interface Consumer.
        // El método intermedio peek() permite ejecutar una acción en cada elemento de la secuencia sin modificarlo.

        // El resultado en consola esta intercalado porque las operaciones se ejecutan en el orden en que se invocan.

        Stream.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")

                .peek(letra -> System.out.println("Peek: " + letra))  // Inspecciona el elemento. No transforma el elemento.
                .map(String::toLowerCase)   // Transforma el elemento. Devuelve el elemento transformado.
                .forEach(letra -> System.out.println("Mapeado: " + letra));  // Imprime el elemento.

        /*
            1- El primer elemento "A" se procesa en la operación peek() y se imprime "Peek: A".
            2- El primer elemento "A" se procesa en la operación map() y se transforma en "a".
            3- El primer elemento "a" se procesa en la operación forEach() y se imprime "Mapeado: a".
            4- El segundo elemento "B" se procesa en la operación peek() y se imprime "Peek: B".
            5- El segundo elemento "B" se procesa en la operación map() y se transforma en "b".
            6- El segundo elemento "b" se procesa en la operación forEach() y se imprime "Mapeado: b".
            7- Y así sucesivamente, hasta el último elemento "J".
         */

        System.out.println("------------------------");

        
        Stream<String> letras = Stream.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
                .map(String::toLowerCase);

        // El método collect() permite convertir un stream en una colección.
        // El método collect() recibe como parámetro un Collector.
        // Collectors va tomando los elementos del stream y los va agregando a la colección.
        // Se pudo usar collect() porque el stream no fue cerrado.
        
        List<String> letrasList = letras.collect(Collectors.toList());

        letrasList.forEach(System.out::println);

        System.out.println("------------------------");

        perrosStream = perros.stream(); // Se crea un nuevo stream a partir de la lista de perros porque el stream
        // anterior fue cerrado.

        // Perro::new es una referencia a un constructor. Es igual a perro -> new Perro(nombre).
        // En vez de usar collect se puede utilizar toList() que es un método de la interface Stream.
        // toList(), al igual que collect(), retorna una lista.

        List<Perro> perrosList = perrosStream.map(Perro::new).toList();

        perrosList.forEach(System.out::println);

        System.out.println("------------------------");

        // El método flatMap se utiliza para convertir un stream de elementos en otro stream mediante la
        // aplicación de una función a cada elemento, y luego "aplanar" los resultados en una sola secuencia.
        // La operación flatMap() recibe como entrada una función lambda que transforma cada elemento de la
        // secuencia de entrada en un Stream de elementos para luego concatenarlos en una única secuencia/stream.
        // La función que se proporciona a flatMap debe devolver un stream de elementos.
        // El resultado final es una secuencia plana (es decir, sin anidamiento) de elementos.
        // flatMap() se ejecuta una vez por cada elemento del stream original.

        // Para que se ejecute distint(), se debe convertir el stream de elementos en un stream plano.

        List<String> strings = Arrays.asList("Hola mundo", "Hola Java", "Hola programación");

        List<String> uniqueWords = strings.stream()
                .flatMap(line -> Arrays.stream(line.split(" ")))
                .distinct()
                .collect(Collectors.toList());

       /*
            Si se desgloza el código anterior, se obtiene lo siguiente una vez que se ejecuta el método flatMap():

            Para la cadena "Hola Mundo", se obtiene un stream con los siguientes valores: "Hola", "Mundo".
            Para la cadena "Hola Java", se obtiene un stream con los siguientes valores: "Hola", "Java".
            Para la cadena "Hola programación", se obtiene un stream con los siguientes valores: "Hola", "programación".

            Luego, se obtiene un stream con los siguientes valores: "Hola", "Mundo", "Hola", "Java", "Hola",
            "programación".

            Cuando se ejecuta el método distinct(), se obtiene un stream con los siguientes valores: "Hola", "Mundo",
            "Java", "programación".
        */

        System.out.println(uniqueWords);

        System.out.println("------------------------");
                  
        //endregion

        //region OPERADOR FILTER

        // El operador filter() permite filtrar los elementos de un stream, utiliza la interface Predicate.
        // Retorna un nuevo stream con los elementos filtrados.
        // El predicado recibe como parámetro el elemento del stream y evaluo si debe ser agregado al nuevo stream.
        // Si el predicado retorna true, el elemento es agregado.
        // Si el predicado retorna false, el elemento no es agregado.

        Stream<String> letrasFiltradas = Stream.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
                .filter(letra -> letra.compareTo("E") > 0);

        letrasFiltradas.forEach(System.out::println);

        System.out.println("------------------------");

        // El operador distinct() permite eliminar los elementos duplicados de un stream.
        // Distinct es un método intermedio, por lo tanto, no se ejecuta hasta que no se invoca un método terminal. 

        Stream<String> palabrasSinDuplicados = Stream.of("Casa", "Auto", "Moto", "Casa", "Moto", "Avion", "Casa", "Moto", "Avion")
                .distinct();

        // Puedo utilizar el método toList() porque el stream todavía no fue cerrado.
        // Si el stream ya fue cerrado (por ejemplo, con un .forEach) no puedo utilizar el método toList()
        List<String> palabras = palabrasSinDuplicados.toList();

        palabras.forEach(System.out::println);

        System.out.println("------------------------");

        // Los métodos luego de filter se ejecutan en el orden en que se invocan.
        // Los elementos que no cumplen con el predicado no se procesan en los métodos siguientes.

        // Un Optional es un contenedor que puede contener un elemento o no.
        // Un Optional es una clase que encapsula un elemento y permite verificar si el elemento está presente o no.

        // findFirst() retorna el primer elemento del stream. Es un método terminal.
        // Si el stream está vacío, retorna un Optional vacío.
        // Si el stream no está vacío, retorna un Optional con el primer elemento del stream.
        // El método get() retorna el elemento del Optional.
        // Si el Optional está vacío, se lanza una excepción, ya el método get se esta llamando sobre un elemento nulo,
        // por ende, hay que utilizar un bloque try-catch.

        String primerAparicion = Stream.of("Casa", "Auto", "Moto", "Casa", "Moto", "Avion", "Casa", "Moto", "Avion")
                .filter(palabra -> palabra.equals("Avion")).findFirst().get();

        System.out.println(primerAparicion);

        System.out.println("------------------------");

        // findAny() retorna un elemento del stream. Es un método terminal. El elemento puede ser el primero o cualquier
        // otro. No se garantiza que sea el primero. Si el stream está vacío, retorna un Optional vacío.
        // Si el stream no está vacío, retorna un Optional con un elemento del stream.
        // El método orElse() retorna el elemento del Optional si el Optional no está vacío. Si el Optional está vacío,
        // retorna el elemento que se le pasa como parámetro.

        String aparicion = Stream.of("Casa", "Auto", "Moto", "Casa", "Moto", "Avion", "Casa", "Moto", "Avion")
                .filter(palabra -> palabra.equals("Moto")).findAny().orElse("No se encontró la palabra");

        System.out.println(aparicion);

        System.out.println("------------------------");

        // anyMatch() retorna true si al menos un elemento del stream cumple con el predicado. Es un método terminal.

        System.out.println("Ingrese en que se mueve por la ciudad: ");
        Scanner scanner = new Scanner(System.in);
        String transporte = scanner.nextLine();

        boolean macth = Stream.of("Auto", "Moto", "Avion", "Autobús", "Camión")
                .anyMatch(palabra -> palabra.equals(transporte));

        System.out.println(macth);

        System.out.println("------------------------");

        // count() retorna la cantidad de elementos del stream. Es un método terminal.
        // Como antes tiene un filter, el count() cuenta los elementos que cumplen con el predicado.

        long count = Stream.of("Auto", "Moto", "", "Avion", "Autobús", "Camión","")
                .filter(String::isEmpty).count();

        System.out.println(count);

        System.out.println("------------------------");

        //endregion

        //region VARIOS

        // reduce() permite reducir los elementos de un stream a un único valor. Es un método terminal.
        // El método reduce() recibe como parámetro un BinaryOperator.
        // El BinaryOperator es una interface que recibe dos parámetros y retorna un valor.

        /*
            El método reduce tiene dos argumentos: el primer argumento es el valor inicial del acumulador,
            que en este caso es una cadena de texto que contiene la frase "Algunas letras del abecedario: ", y el
            segundo argumento es una función lambda que toma dos argumentos y devuelve un valor que se utiliza como
            entrada para el siguiente llamado de la función.

            La función lambda en este caso toma dos cadenas de texto, a y b, y las concatena separándolas por un guion
            (-). La cadena resultante se utiliza como valor de retorno para la próxima llamada a la función lambda, en
            la que a será la cadena resultante anterior y b será el siguiente elemento del Stream.

         */


        String resultado = Stream.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
                .reduce("Algunas letras del abecedario: ", (a, b) -> a + "-" + b);

        System.out.println(resultado);

        System.out.println("------------------------");

        Integer factorial = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(1, (a, b) -> a * b);

        System.out.println(factorial);

        System.out.println("------------------------");

        // IntStream es una interface que permite trabajar con streams de enteros.
        IntStream range = IntStream.range(1, 20);

        int result = range.reduce(0, Integer::sum);

        System.out.println(result);

        System.out.println("------------------------");

        //rangeClosed() a diferencia de range(), incluye el último elemento.
        IntStream rangeClose = IntStream.rangeClosed(5, 25);

        // IntSummaryStatistics es una clase que permite obtener estadísticas de un stream de enteros.
        IntSummaryStatistics summaryStatistics = rangeClose.summaryStatistics();

        System.out.println("Cantidad de elementos: " + summaryStatistics.getCount());
        System.out.println("Suma de los elementos: " + summaryStatistics.getSum());
        System.out.println("Promedio de los elementos: " + summaryStatistics.getAverage());
        System.out.println("Mínimo de los elementos: " + summaryStatistics.getMin());
        System.out.println("Máximo de los elementos: " + summaryStatistics.getMax());

        System.out.println("------------------------");

        // mapToInt() permite transformar un stream de elementos a un stream de enteros.
        Stream<String> nombres2 = Stream.of("Juan","Pedro","Maria","Agus","Juan","Maria","Barbara");

        nombres2.distinct().mapToInt(String::length).forEach(System.out::println);

        System.out.println("------------------------");

        Persona p1 = new Persona("Agustin", "Battisti", "40884962", "Mar del Plata", 2);

        p1.addMascota("Pepito");
        p1.addMascota("Firulais");

        Persona p2 = new Persona("Juan", "Perez", "123456789", "Capital", 2);

        p2.addMascota("Pelusa");
        p2.addMascota("Ricardo");

        List<Persona> personas = Arrays.asList(p1, p2);

        List<String> mascotas = personas.stream().flatMap(persona -> Arrays.stream(persona.getMascotas())).toList();

        System.out.println("mascotas = " + mascotas);

        System.out.println("------------------------");

        Persona per1 = new Persona("Agustin", "Battisti");
        Persona per2 = new Persona("Barbara", "Basualdo");
        Persona per3 = new Persona("Sebastian", "Gimenez");
        Persona per4 = new Persona("Maria", "Perez");

        List<Persona> personasList = Arrays.asList(per1,per2,per3,per4);

        // Stream.empty() retorna un stream vacío (sin elementos).
        // parallel() permite ejecutar el stream en paralelo, es decir, en varios hilos.
        // En este caso, se ejecuta en 4 hilos (cantidad de núcleos de la CPU).
        // Cuando un Stream se ejecuta en paralelo, las operaciones intermedias y finales se realizan en múltiples
        // hilos de ejecución, lo que puede mejorar significativamente el rendimiento en ciertas situaciones.

        // En un Stream paralelo, las operaciones intermedias se dividen en suboperaciones que se ejecutan en hilos
        // separados, lo que permite procesar los elementos de la secuencia más rápidamente. Después de que se hayan
        // procesado todas las suboperaciones, los resultados se combinan en un resultado final.

        personasList.stream()
                .parallel()
                .map(persona -> persona.getNombre().toUpperCase().concat(" ").concat(persona.getApellido().toUpperCase()))
                .flatMap(nombre -> {

                    if(nombre.contains("Maria".toUpperCase())) {

                        return Stream.of(nombre); // Retorna un stream con un elemento.
                    }
                    else{
                        return Stream.empty();
                    }
                }).forEach(System.out::println);

        System.out.println("------------------------");

        // Stream.generate() permite generar un stream infinito de elementos mediante la aplicación de una función
        // TimeUnit.SECONDS.sleep(2) hace que el hilo principal se duerma durante 2 segundos.
        // limit(5) limita la cantidad de elementos del stream a 5.
        // AtomicInteger es una clase que permite trabajar con enteros de forma atómica, es decir, si dos hilos intentan
        // incrementar el mismo valor, el resultado será el correcto.
        // AtomicInteger contador = new AtomicInteger(0); inicializa el contador en 0.
        // contador.incrementAndGet() incrementa el contador en 1 y retorna el valor actual.

        AtomicInteger contador = new AtomicInteger(0);

        Stream.generate(() -> {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "Hola mundo " + contador.incrementAndGet();}).limit(5).forEach(System.out::println);

        //endregion
    }
}
