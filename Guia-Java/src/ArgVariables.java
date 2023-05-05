public class ArgVariables {

    public static void main(String[] args) {

        System.out.println(sumarNumeros(4, 8, 7, 9, 6));
    }

    public static int sumarNumeros(int... enteros) { // Los "..." significan que se van a tomar una cantidad de
                                                     // argumentos variables. Estos se transforman en un arreglo

        int result = 0;

        for (int num : enteros) {

            result += num;
        }

        return result;

    }

}
