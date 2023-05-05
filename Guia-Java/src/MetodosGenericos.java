import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MetodosGenericos {

    public static void main(String[] args) {

        Integer[] arreglo = { 1, 2, 3, 4, 5, 6 };

        Float[] arreglo2 = { 1.5f, 2.7f, 3.9f, 4.8f };

        List<Integer> lista = fromArrayToList(arreglo);

        List<Integer> lista2 = fromArrayToList(arreglo, arreglo2); // Transforma en lista al primero y lo retorna, e
                                                                   // imprime al segundo.

        System.out.println(lista.getClass());
        System.out.println(lista2.getClass());

        System.out.println("El máximo entre 24, 80 y 17 es: " + maximo(24, 80, 17));

    }

    public static <T> List<T> fromArrayToList(T[] c) { // T se toma como referencia para las listas. El método va a
                                                       // retornar una lista del tipo de arreglo que le pase.
                                                       // Entre las desigualdades se ponen los genéricos a usar.

        return Arrays.asList(c);
    }

    public static <T extends Number, G> List<T> fromArrayToList(T[] c, G[] x) { // Utilizo el polimorfismo. Al utilizar
                                                                                // el "extends" estoy limitando el tipo
                                                                                // de dato, ya que la clase Number tiene
                                                                                // como hijas todas las clases
                                                                                // numéricas, por ende no podría usar
                                                                                // Srting por ejemplo.

        for (G elemento : x) {
            System.out.println(elemento);
        }

        return Arrays.asList(c);
    }



    public void imprimirNumeros(List<? extends Number> numeros) { // Con el "?" (comodín) indico que pueden ser
                                                                         // todas las clases hijas del padre del cual se
                                                                         // extiende. Estoy limitando el parámetro.

    }

    public <E extends Number> void imprimirNumeros2(List<E> numeros) { // Es lo mismo que arriba pero de diferente manera.
    }

    public static <T extends Comparable<T>> T maximo(T a, T b, T c) { // Como T es una clase que hereda de Comparable,
                                                                      // en los genericos T podemos usar los métodos de
                                                                      // la clase Comparable.

        T max = a;

        if (b.compareTo(max) > 0) {

            max = b;
        }

        if (c.compareTo(max) > 0){

            max = c;
        }

        return max;

    }

    public <T extends Number> T saludar() {

        return null;

    }

}
