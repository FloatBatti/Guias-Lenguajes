import java.util.Arrays;
import java.util.Random;

public class Arreglos {

    public static void main(String[] args) {

        int[] edades = new int[5];  // Se puede instanciar con el constructor
        String[] nombres = {"Agustin", "Juan", "Jose"};  // Se puede instanciar sin el constructor y poniendo los datos a la primera
        int[][] matriz = new int[3][];
        String[][] matriz2 = {{"Agustin", "Juan"}, {"Maria", "Julieta"}};

        Random rand = new Random();

        for (int i = 0; i < edades.length; i++) {

            edades[i] = rand.nextInt(11);
        }

        Arrays.sort(edades);  // Ordena un arreglo
        System.out.println("edades = " + Arrays.toString(edades));
        System.out.println("matriz2= " + Arrays.deepToString(matriz2));  // Se utiliza deep asi convierte en String los arreglos que son elementos de otro arreglo

        // Si a la matriz no le indico las columnas lo puedo hacer variable
        matriz[0] = new int[2];
        matriz[1] = new int[3];
        matriz[2] = new int[4];

        for (int[] ints : matriz) {

            for (int anInt : ints) {

                System.out.print(anInt + "\t");
            }
            System.out.println(); // Es como si se haría un enter, es decir, se va a la siguiente línea
        }

        // EJEMPLO DE ORDENAMIENTO CON ALGORITMO BURBUJA

        int[] des = {9, 5, 1, 8, 2, 7, 4, 3, 6};

        while (true) {

            boolean cambio = false;

            for (int i = 0; i < des.length-1; i++) {

                if (des[i + 1] < des[i]) {

                    int aux = des[i];
                    des[i] = des[i + 1];
                    des[i + 1] = aux;
                    cambio = true;
                }

            }

            if (!cambio){
                break;
            }

        }

        System.out.println(Arrays.toString(des));


        // EJEMPLO DE ORDENAMIENTO CON ALGORITMO QUICKSORT (El más rápido)

        int[] array = {9, 5, 1, 8, 2, 7, 4, 3, 6};

        


    }
}
