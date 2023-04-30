package com.agusbatti.anotaciones;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.Arrays;

public class EjemploAnotacion {

    public static void main(String[] args) {

        Producto producto = new Producto("chocolate", 100.0, LocalDate.of(2021, 12, 31));


        // Se obtienen los campos (atributos) de la clase Producto.
        Field[] campos = producto.getClass().getDeclaredFields();

        Arrays.stream(campos)
                // isAnnotationPresent() devuelve true si el atributo tiene la anotación indicada.
                // Anotaciones.class es la clase que representa la anotación.
                // Se filtran los campos (atributos) que tienen la anotación 'Anotaciones'.
                .filter(field -> field.isAnnotationPresent(Anotaciones.class))

                // Se transforma cada campo en su nombre o en el valor de la anotación nombre(), dependiendo de si
                // esta última está vacía o no. Es decir, si la anotación no tiene ningún valor para el atributo
                // nombre(), se utiliza el nombre del campo (atributo) en su lugar.
                .map(f ->{

                    // getAnnotation() devuelve la anotación indicada.
                    // nombre() devuelve el valor del atributo nombre de la anotación.
                    // El valor de la anotación es el que se escribió en la clase Producto, en el atributo
                    // nombre de la anotación. Si no se especifica ningún valor, el valor por defecto es
                    // "Sin anotación".

                    return f.getAnnotation(Anotaciones.class).nombre().equals("Sin anotación")
                    ? f.getName()
                    : f.getAnnotation(Anotaciones.class).nombre();

                    // ifPresent() ejecuta el método println() si la cadena no es nula.
                }).reduce((a, b) -> a + ", " + b).ifPresent(System.out::println);


        // Se filtran los campos que tienen la anotación 'Anotaciones' y que además tienen el atributo
        // capitalizar() en true.
        Arrays.stream(campos).filter(field -> field.isAnnotationPresent(Anotaciones.class) &&
                        field.getAnnotation(Anotaciones.class).capitalizar())
                .map(filed ->{

                    String descripcion = producto.getDescripcion();

                        producto.setDescripcion(descripcion.substring(0,1).toUpperCase()
                                + descripcion.substring(1).toLowerCase());

                    return "Cambio con exito";

                }).forEach(System.out::println);

        /*

        // Otra forma de hacer lo mismo que el código anterior, utilizando forEach() en lugar de map().

        Arrays.stream(campos).filter(field -> field.isAnnotationPresent(Anotaciones.class) &&
                        field.getAnnotation(Anotaciones.class).capitalizar())
                .forEach(filed ->{

                    String descripcion = producto.getDescripcion();

                    producto.setDescripcion(descripcion.substring(0,1).toUpperCase()
                            + descripcion.substring(1).toLowerCase());
                });

        */

        System.out.println(producto.getDescripcion());

        // Se obtienen los métodos de la clase Producto.
        Method[] metodos = producto.getClass().getDeclaredMethods();

        Arrays.stream(metodos).filter(m -> m.isAnnotationPresent(Anotaciones.class))
                .forEach(m -> {

                    try {
                        // setAccessible() permite acceder a métodos privados.
                        m.setAccessible(true);
                        // invoke() ejecuta el método.
                        m.invoke(producto);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                });

    }


}
