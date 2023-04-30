import com.agusbatti.clases.Componente;

import java.util.stream.Stream;

public class Recursividad {

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Factorial de " + n + " es " + factorial(n));

        Componente gab = new Componente("Gabinete");
        Componente mother = new Componente("Motherboard");
        Componente cpu = new Componente("Procesador");
        Componente dis = new Componente("Disipador");
        Componente ram1 = new Componente("4 GB RAM");
        Componente ram2 = new Componente("4 GB RAM");
        Componente ssd = new Componente("Disco Duro");
        Componente gpu = new Componente("Tarjeta de Video");
        Componente fuente = new Componente("Fuente de Poder");
        Componente coolerGPU = new Componente("Ventilador");
        Componente coolerGab = new Componente("Ventiladores gabinete");

        cpu.add(dis).add(coolerGPU);
        mother.add(cpu).add(ram1).add(ram2).add(gpu);
        gab.add(mother).add(ssd).add(fuente).add(coolerGab);

        //recursivo(gab, 0);

        recursivoStream(gab, 0).forEach(c -> System.out.println("\t".repeat(c.getNivel()) + c.getNombre()));
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static Stream<Componente> recursivoStream(Componente c, int nivel){

        c.setNivel(nivel);

        // concat concatena dos streams, en este caso, el stream del componente actual y el stream de los hijos.
        // La recursividad termina cuando no hay mas hijos. Si el stream de los hijos esta vacio, concat no hace
        // nada. Si no esta vacio, concat concatena el stream del componente actual con el stream de los hijos.

        // En este caso, flatMap es necesario porque el stream de los hijos es un stream de streams, es decir,
        // un stream de streams de componentes. flatMap convierte el stream de streams en un stream de componentes.

        return Stream.concat(Stream.of(c), c.getHijos().stream().flatMap(comp -> recursivoStream(comp, nivel + 1)));
    }

    public static void recursivo(Componente c, int nivel){

        // Tabula segun el nivel de profundidad, por ejemplo, si es el segundo nivel, tabula dos veces.
        System.out.println("\t".repeat(nivel)+ c.getNombre());

        // La recursividad termina cuando no hay mas hijos, es decir, cuando el for termina.
        for(Componente comp : c.getHijos()){
            recursivo(comp, nivel + 1);
        }
    }
}
