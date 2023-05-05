import com.agusbatti.clases.Persona;

import java.util.*;
import java.util.Map.Entry;

public class Colecciones {

    public static void main(String[] args) {

        // Cada grupo de interfaces suelen compartir varios métodos heredados.
        // Un ejemplo es el método add presente en todos los tipos de listas.
        // El método add devuelve true o false indicando si fue agregado o no.
        // Sirve para detectar duplicados en los sets.
        // Lo que esta dentro de Collection tiene un Iterator que se utiliza con un while.

        //region INTERFAZ LIST

        System.out.println("---------- LIST ----------");

        ArrayList<String> nombres = new ArrayList<String>(); // Es un arreglo dinámico (puedo cambiar su tamaño en
        // tiempo de ejecución) o lista simplemente enlazada.
        // Permite elementos duplicados. Mantiene el orden de inserción.

        nombres.add("Agustin");
        nombres.add("Juan");
        nombres.add(1, "Pedro");  // Inserta un elemento en la posición indicada. Los elementos 
        // que estaban en esa posición se desplazan una posición a la derecha.

        nombres.set(1, "Agustin"); // Reemplaza el elemento en la posición indicada por el elemento indicado.

        System.out.println("nombres" + nombres);

        ArrayList<String> otrosNombres = new ArrayList<>(Arrays.asList("Juan", "Pedro", "Agustin")); // Con asList puedo
        // instanciar una lista con elementos.

        System.out.println("otrosNombres.size(): " + otrosNombres.size());

        otrosNombres.remove(0);  // Remueve el elemento que se encuentra en el indice indicado.
        otrosNombres.remove("Agustin"); // Remueve el elemento indicado por instancia (utiliza equals).

        LinkedList<String> animales = new LinkedList<String>(Arrays.asList("Perro", "Gato", "Vaca", "Leon"));

        // Es una lista doblemente enlazada. Permite elementos repetidos. Mantiene el orden de inserción. Su 
        // manipulacion es más rapida. Se puede operar con el útlimo y primer elemento de la lista.

        animales.removeLast(); // Remueve el último
        animales.removeFirst(); // Remueve el primero

        System.out.println("animales: " + animales);

        Vector<Persona> personas = new Vector<Persona>(); // Es parecido a una lista pero esta si es está sincornizada
        // (se puede compartir una misma instancia entre varios hilos). Contiene mas métodos fuera del marco de las
        // colecciones.

        Persona persona1 = new Persona("Agustin", "Battisti", "12345678", "MDP", 2);
        personas.add(persona1);
        System.out.println("Posicion de persona1 en el vector personas: " + personas.indexOf(persona1));

        Stack<Integer> numeros = new Stack<Integer>(); // Es una estructura de tipo LIFO (last in - first out), es
        // decir, una pila, donde el último que ingresa es el primero que sale.

        numeros.push(5); // Inserta un elemento
        numeros.push(8);
        numeros.pop(); // Remueve y devuelve el primer elemento, es decir, el último en ingresar
        numeros.peek(); // Devuelve pero no elimina el primer elemento de la pila

        List<Float> numerosFloat = new ArrayList<Float>(Arrays.asList(5.8f, 6.9f, 3.2f, 14.7f)); // Se puedo usar List
        // de manera general y luego especificar en la instanciación

        numerosFloat.clear(); // Remueve todos los elementos de una lista

        Persona persona2 = new Persona("Juan", "Perez", "87654231", "CABA", 2);
        Persona persona3 = new Persona("Pedro", "Gomez", "963258741", "MDP", 2);

        ArrayList<Persona> personasArrayList = new ArrayList<Persona>(Arrays.asList(persona1, persona2, persona3));

        Collections.sort(personasArrayList);  // Permite ordenar una lista de objetos que implementen la interfaz
        // Comparable. En este caso ordena por dni.

        animales.add("Tortuga");
        animales.add("Conejo");
        ListIterator<String> listIterator = animales.listIterator();  // Solo sirve para linkedList.

        while (listIterator.hasNext()) {  // hasNext devuelve true si hay un elemento siguiente.

            // .nextIndex() devuelve el índice del elemento siguiente.
            // .next() devuelve el elemento siguiente.
            System.out.println("Indice en " + listIterator.nextIndex() + ": " + listIterator.next());

        }

        System.out.println("El indice quedo en el último elemento de la lista y ahora recorro hacia atrás:");

        while (listIterator.hasPrevious()) {  // hasPrevious devuelve true si hay un elemento anterior.

            // .previousIndex() devuelve el indice del elemento anterior.
            // .previous() devuelve el elemento anterior.
            System.out.println("Indice en " + listIterator.previousIndex() + ": " + listIterator.previous());
        }

        //endregion

        //region INTERFAZ QUEUE

        System.out.println("---------- QUEUE ----------");

        PriorityQueue<Integer> integerPriority = new PriorityQueue<>(); // Es una estructura de tipo FIFO (first in -
        // first out), es decir, una cola, donde el primero que entra es el primero que sale.
        // Los elementos que contiene van a ser procesados por prioridad y no permire nulos.

        integerPriority.add(5);
        integerPriority.add(6);
        integerPriority.poll(); // Devuelve el elemento que esta en la cabecera de la cola y lo remueve.

        ArrayDeque<Integer> empleadosDeque; // A diferencia de la cola podemos eliminar elementos de ambos extremos. Es mas
        // rápido que ArrayList y Stack.

        empleadosDeque = new ArrayDeque<Integer>(Arrays.asList(7, 8, 5, 3, 9));

        empleadosDeque.peek(); // Devuelve el elemento que esta en la cabecera de la cola pero no lo remueve.
        empleadosDeque.addFirst(6); // Inserta un elemento en la cabecera de la cola
        empleadosDeque.addFirst(38);
        empleadosDeque.addLast(2); // Inserta un elemento al final de la cola
        empleadosDeque.addLast(19);
        empleadosDeque.removeLast(); // Remueve el último elemento
        empleadosDeque.removeFirst(); // Remueve el primer elemento

        System.out.println("Cola empleadosDeque: " + empleadosDeque);

        //endregion

        //region INTERFAZ SET

        System.out.println("---------- SET ----------");

        HashSet<String> hashSets = new HashSet<String>(); // Utiliza la tabla hash para el almacenamiento a travéz del
        // hashing. Los elementos deben ser únicos. No se guardan con un orden especifico. Permite elementos nulos.

        hashSets.addAll(animales); // Agrega todos los elementos de otra Collecion.
        hashSets.add("Mono");
        hashSets.add("Mono");  // En este caso devuelve false porque ya existe el elemento en la estructura.  

        System.out.println("Estructura Hash: " + hashSets);

        LinkedHashSet<String> linkedSet = new LinkedHashSet<String>(); // Extiende de la clase HashSet y tambien permite
        // unicamente elementos únicos. Mantiene el orden de inserción y permite elementos nulos.

        linkedSet.addAll(otrosNombres);
        linkedSet.add("Maria");
        linkedSet.add("Facundo");
        linkedSet.add("Daniel");

        System.out.println("Estructura LinkedHashSet: " + linkedSet);

        TreeSet<Integer> arbolInteger1 = new TreeSet<>(); // Utiliza un árbol para el almacenamiento. Contiene
        // elementos únicos. Tiene el timpo de recuperación más rápido de los Sets. Los elementos son ordenados de
        // forma natural (numericamente o alfabeticamente) y de manera ascendente.

        arbolInteger1.add(8);
        arbolInteger1.add(2);
        arbolInteger1.add(3);
        arbolInteger1.add(9);

        System.out.println("Arbol natural : " + arbolInteger1);

        TreeSet<Integer> arbolInteger2 = new TreeSet<>(Comparator.reverseOrder()); // Se ordena de forma inversa

        arbolInteger2.add(8);
        arbolInteger2.add(2);
        arbolInteger2.add(3);
        arbolInteger2.add(9);

        System.out.println("Arbol inverso : " + arbolInteger2);


        //endregion

        //region INTERFAZ MAP

        System.out.println("---------- MAP ----------");

        // Esta interfaz permite almacenar datos de manera clave-valor (<c , v>) de
        // manera que para una clave solo se tiene un valor. Se conoce como diccionario.

        HashMap<Integer, String> map = new HashMap<Integer, String>(); // No hay un orden especifico. No se aceptan
        // valores nulos.

        map.put(1, "Agustín");
        map.put(15, "Juan");
        map.put(27, "Lucas");
        map.put(3, "Pedro");

        // Se imprime el Map con un Iterador. El iterador tiene que ser del mismo tipo
        // de dato que utilizemos como iterador en el iterable.
        Iterator<Integer> it = map.keySet().iterator();

        while (it.hasNext()) {
            Integer key = it.next();
            System.out.println("Clave: " + key + " -> Valor: " + map.get(key));
        }

        TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>(); // Árbol pero con clave valor.
        // Se ordena en función de la clave.


        treeMap.put(2, "Mar del Plata");
        treeMap.put(37, "Pinamar");
        treeMap.put(11, "Necochea");
        treeMap.put(1, "Tandil");

        // Se imprime el Map con el Iterador que se instancio anteriormente
        it = treeMap.keySet().iterator();

        while (it.hasNext()) {
            Integer key = it.next();
            System.out.println("Clave: " + key + " -> Valor: " + treeMap.get(key));
        }

        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<Integer, String>(); // Se ordena en función de como se van
        // introduciendo los elementos.

        linkedHashMap.put(2, "Jose");
        linkedHashMap.put(37, "Camila");
        linkedHashMap.put(11, "Nicolas");
        linkedHashMap.put(1, "Maria");

        // Una forma alternativa de como iterar Maps.

        // Entry es una interfaz que representa una entrada (clave - valor) de un Map.
        // Se utiliza el método entrySet() del Map que devuelve un Set de tipo Entry.
        // El Set de tipo Entry es un conjunto de entradas de un Map.
        // Entry tiene dos métodos getKey() y getValue() que nos permiten obtener la clave y el valor de la entrada.

        for (Entry<Integer, String> alumno : linkedHashMap.entrySet()) {
            Integer clave = alumno.getKey();
            String valor = alumno.getValue();
            System.out.println(clave + "  ->  " + valor);
        }

        // Métodos del Map

        System.out.println("********* Métodos de Map *********");
        System.out.println("Mostramos el numero de elementos que tiene el TreeMap: treeMap.size() = " + treeMap.size());
        System.out.println("Vemos si el TreeMap esta vacio : treeMap.isEmpty() = " + treeMap.isEmpty());
        System.out.println("Obtenemos un elemento del Map pasandole la clave 11: treeMap.get(11) = " + treeMap.get(11));
        System.out.println("Borramos un elemento del Map el 1: treeMap.remove(1) " + treeMap.remove(1));
        System.out.println(
                "Vemos que pasa si queremos obtener la clave 1 que ya no existe: treeMap.get(1) = " + treeMap.get(1));
        System.out.println(
                "Vemos si existe un elemento con la clave 1: treeMap.containsKey(18) = " + treeMap.containsKey(1));
        System.out.println(
                "Vemos si existe un elemento con la clave 11: treeMap.containsKey(11) = " + treeMap.containsKey(11));
        System.out
                .println("Vemos si existe el valor 'Mar del Plata' en el Map: treeMap.containsValue('Mar del Plata') = "
                        + treeMap.containsValue("Mar del Plata"));
        System.out.println("Vemos si existe el valor 'Villa Gesell' en el Map: treeMap.containsValue('Villa Gesell') = "
                + treeMap.containsValue("Villa Gesell"));
        System.out.println("Borramos todos los elementos del Map: treeMap.clear()");
        treeMap.clear();
        System.out.println("Comprobamos si lo hemos eliminado viendo su tamaño: treeMap.size() = " + treeMap.size());
        System.out.println("Lo comprobamos tambien viendo si esta vacio treeMap.isEmpty() = " + treeMap.isEmpty());

        //endregion
    }
}
