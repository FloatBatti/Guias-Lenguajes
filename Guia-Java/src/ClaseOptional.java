import com.agusbatti.clases.Persona;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ClaseOptional {

    public static void main(String[] args) {

        // La clase Optional es una clase que nos permite trabajar con valores nulos de una forma más segura.
        // Representa un valor opcional, es decir, puede contener un valor o no.
        // Se utiliza para evitar el NullPointerException en tiempo de ejecución.
        // Encapsula un objeto que puede ser nulo o no. Es como un contenedor que puede contener un solo valor o no.
        // Es una clase final, por lo que no se puede heredar de ella.
        
        String nombre = "Gonzalo";
        String apellido = null;

        // of() nos permite crear un Optional a partir de un objeto que no sea nulo. Si el objeto es nulo, lanza una
        // excepción de tipo NullPointerException.

        Optional<String> nombreOptional = Optional.of(nombre);
        System.out.println("nombreOptional = " + nombreOptional);

        System.out.println("------------------------");

        // isPresent() nos permite saber si el Optional contiene un valor o no. Devuelve true o false.
        if(nombreOptional.isPresent()) {

            // get() nos permite obtener el valor del Optional. Si el Optional está vacío, lanza una excepción de tipo
            // NoSuchElementException.
            System.out.println("El nombre es: " + nombreOptional.get());

        } else {
            System.out.println("nombreOptional está vacío");
        }

        System.out.println("------------------------");

        // ofNullable() nos permite crear un Optional vacío si el objeto es nulo. Si el objeto no es nulo, crea un
        // Optional con el valor del objeto.
        Optional<String> apellidoOptional = Optional.ofNullable(apellido);
        System.out.println("apellidoOptional = " + apellidoOptional);

        System.out.println("------------------------");

        // empty() nos permite crear un Optional vacío.
        Optional<String> apellidoOptional2 = Optional.empty();

        // ifPresent() nos permite ejecutar un código si el Optional contiene un valor. Si el Optional está vacío,
        // no se ejecuta el código.
        nombreOptional.ifPresent(u -> System.out.println(u.toUpperCase()));

        System.out.println("------------------------");

        // ifPresentOrElse() nos permite ejecutar un código si el Optional contiene un valor. Si el Optional está vacío,
        // se ejecuta el código del segundo parámetro.
        apellidoOptional.ifPresentOrElse(
                u -> System.out.println(u.toUpperCase()),
                () -> System.out.println("No hay apellido")
        );

        System.out.println("------------------------");

        List<Persona> nombres = new ArrayList<>(Arrays.asList(new Persona("Agustin", "Battisti"), new Persona("Gonzalo", "Battisti"), new Persona("Maria", "Gomez")));

        // orElse() nos permite obtener el valor del Optional. Si el Optional está vacío, devuelve el valor que
        // le pasamos por parámetro.
        // El orElse() se ejecuta siempre, aunque el Optional no esté vacío.

        String nombreBuscado = "Gonzalo";

        Persona personaEncontrada = nombres.stream()
                .filter(u -> u.getNombre().equalsIgnoreCase(nombreBuscado))
                .findAny()
                .orElse(crearPersona(nombreBuscado));

        System.out.print("Con orElse(): " + personaEncontrada);

        // orElseGet() nos permite obtener el valor del Optional. Si el Optional está vacío, devuelve el valor que
        // le pasamos por parámetro.
        // El orElseGet(), a diferencia de orElse(), se ejecuta solo si el Optional está vacío. Es mas eficiente.

        String nombreBuscado2 = "Agustin";

        Persona personaEncontrada2 = nombres.stream()
                .filter(u -> u.getNombre().equalsIgnoreCase(nombreBuscado2))
                .findAny()
                .orElseGet(() -> crearPersona(nombreBuscado2));

        System.out.print("Con orElseGet(): " + personaEncontrada2);

        System.out.println("------------------------");

        // En vez de get() se recomienda usar orElseThrow() para obtener el valor del Optional. Si el Optional está
        // vacío, lanza una excepción de tipo NoSuchElementException.
        // Utilizar orElseThrow() es una mejor práctica ya que tiene mas sentido.
        // get() se recomienda usarlo solo si estamos seguros de que el Optional no está vacío, por ejemplo, utilizando
        // el método isPresent().

        String nombreBuscado3 = "Carlos";

        try {

            Persona personaEncontrada3 = nombres.stream()
                    .filter(u -> u.getNombre().equalsIgnoreCase(nombreBuscado3))
                    .findAny()
                    .orElseThrow();
        } catch (Exception e) {

            System.out.println("No se encontró la persona");
        }

        System.out.println("------------------------");

    }

    private static Persona crearPersona(String nombre) {
        System.out.println("Creando persona...");
        return new Persona(nombre, null);
    }


}
