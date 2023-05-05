import java.util.Random;

public class ClaseMath {

    public static void main(String[] args) {

        int absoluto = Math.abs(-3);  // Retorna el valor absoluto de un número pasado como parámetro
        System.out.println("absoluto = " + absoluto);

        double max = Math.max(3.5, 1.2);  // Retorna el valor máximo entre dos números
        System.out.println("max = " + max);

        double min = Math.min(3.5, 1.2);  // Retorna el valor mínimo entre dos números
        System.out.println("min = " + min);
        
        double techo = Math.ceil(3.5);  // Retorna un número redondeado hacia arriba (techo)
        System.out.println("techo = " + techo);

        double piso = Math.floor(3.5);  // Retorna un número redondeado hacia abajo (piso)
        System.out.println("piso = " + piso);

        long entero = Math.round(5.5565);  //  Retorna un número entero redondeado para arriba o abajo dependiendo de sus decimales (mayor o menor que 5)
        System.out.println("entero = " + entero);

        long entero2 = Math.round(5.49865);
        System.out.println("entero2 = " + entero2);
        

        // TRIGONOMETRÍA

        double pi = Math.PI;
        System.out.println("pi = " + pi);

        double exp = Math.exp(2);  // Usa como base la constante e y la eleva al número pasado como parámetro
        System.out.println("exp = " + exp);

        double log = Math.log(10);  // Es el logaritmo natural (en bas e) de 10
        System.out.println("log = " + log);

        double potencia = Math.pow(10, 3);  // 10 elevado a la 3
        System.out.println("potencia = " + potencia);

        double raiz = Math.sqrt(5);  // Retorna la raíz cuadrada del número pasado como parámetro
        System.out.println("raíz = " + raiz);

        double grados =  Math.toDegrees(1.57);  // Pasa de radianes a grados
        grados = Math.round(grados);
        System.out.println("grados = " + grados);
        
        double radianes = Math.toRadians(90);  // Pasa de grados a radianes
        System.out.println("radianes = " + radianes);

        System.out.println("sin(90): " + Math.sin(radianes));  // Calcula el seno
        System.out.println("cos(90): " + Math.cos(radianes));  // Calcula el coseno


        // RANDOM

        double random = Math.random();  // Devuelve un número aleatorio entre 0 y 1. Nunca llega hasta el 1, se excluye
        System.out.println("random = " + random);
        random *= 7;  // Hace que el random sea hasta 7 sin incluirlo
        System.out.println("random hasta 7 = " + Math.round(random));

        Random randomObject = new Random();  // Es mucho más amplio y flexible que Math

        int randomInt = randomObject.nextInt(7);  // Devuelve unr random entre 0 y 7 sin incluirlo
        System.out.println("randomInt = " + randomInt);

        float randomFloat = 15 + randomObject.nextFloat(50-15);  // Devuelve un random entre 15 y 50. Primero se suma 15 para indicar que se parte de ese número y luego se le resta al parámetro
        System.out.println("randomFloat = " + randomFloat);

        double randomDouble = randomObject.nextDouble();
        System.out.println("randomDouble = " + randomDouble);

    }


}
