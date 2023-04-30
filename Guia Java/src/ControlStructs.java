import java.util.Scanner;

public class ControlStructs {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int opcion = scan.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Opción 1");
                break;
            case 2:
                System.out.println("Opción 2");
                break;
            case 3:
                System.out.println("Opción 3");
                break;
            case 4: case 5: case 6:  // Se pueden agrupar varias opciones en un mismo case
                System.out.println("Opción 4, 5 o 6");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        System.out.println("-----------------------------------------");

        for (int i = 0; i < 10; i++) {

            System.out.println("i = " + i);
        }

        System.out.println("-----------------------------------------");

        bucle2:  // Sirve para indicar en que estructura de control se aplica un break o un continue
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 2; j++) {

                if (i % 2 == 0)
                    continue bucle2;  // Saltea el bloque de ejecución que le sigue y pasa a la siguiente iteración

                System.out.println("Estoy en el Bucle1");
            }

            System.out.println("i = " + i);
        }

        System.out.println("-----------------------------------------");

        int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        // Formas de recorrer array

        // 1. For tradicional
        for (int i = 0; i < array.length; i++) {

            System.out.println(array[i]);
        }

        System.out.println("-----------------------------------------");

        // 2. For each
        for (int num : array) {

            System.out.println(num);
        }

        System.out.println("-----------------------------------------");

        // 3. While

        int i = 0;

        while (i < array.length) {

            System.out.println(array[i]);
            i++;
        }

        System.out.println("-----------------------------------------");

        // 4. Do while

        i = 0;

        do {

            System.out.println(array[i]);
            i++;
        } while (i < array.length);
    }
}
