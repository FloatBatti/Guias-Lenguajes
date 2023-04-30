import com.agusbatti.anotaciones.Producto;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class Reflexion {
    public static void main(String[] args) {

        // Java utiliza la reflexión para obtener información sobre las clases, métodos, atributos, etc.
        // La reflexión es el proceso de analizar una clase en tiempo de ejecución para obtener información
        // sobre sus atributos, métodos, etc.
        // La reflexión permite a los programadores acceder y modificar los campos, métodos y constructores de una
        // clase, y también permite examinar los tipos de datos, las interfaces y los atributos de los objetos.
        // Con la reflexión, los programas pueden crear objetos de clases dinámicamente, invocar métodos en tiempo
        // de ejecución y cambiar el comportamiento de una aplicación en tiempo de ejecución.

        Producto producto = new Producto("Chocolate", 150.0, LocalDate.of(2021, 12, 31));

        // Field es una clase que representa un atributo de una clase.
        // getDeclaredFields() devuelve un array con todos los atributos de la clase.

        Field[] campos = producto.getClass().getDeclaredFields();

        // getClass() devuelve la clase de un objeto.
        // ? significa que no sabemos el tipo de la clase.
        Class<?> clasePersona = producto.getClass();

        // SE OBTIENE INFORMACIÓN DE LA CLASE

        // Imprimimos el nombre y el tipo de cada campo
        for (Field campo : campos) {

            // getName() devuelve el nombre del campo.
            System.out.println("Nombre: " + campo.getName());

            // getType() devuelve el tipo del campo.
            System.out.println("Tipo: " + campo.getType());
        }

        System.out.println("----------------------");

        // SE MODIFICA EL VALOR DE UN CAMPO

        try {
            // Lleva try-catch porque puede lanzar una excepción si el campo no existe.
            Field nombre = clasePersona.getDeclaredField("nombre");

            // setAccessible(true) permite acceder a un campo que tiene un modificador de acceso private.
            nombre.setAccessible(true);

            // set() permite modificar el valor de un campo.
            nombre.set(producto, "Coca-Cola");

            System.out.println(producto.getDescripcion());

        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }



}
