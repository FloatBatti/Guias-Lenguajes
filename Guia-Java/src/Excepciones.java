import java.util.Scanner;

import com.agusbatti.clases.DivXceroExcepcion;

public class Excepciones {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese un divisor: ");

        try {

            int divisor = Integer.parseInt(scan.nextLine());

            scan.close();

            int division = 10 / divisor;

            System.out.println(division); // No se muestra si hay error

        } catch (NumberFormatException nfe) {

            System.out.println("Hubo un error con el tipo de formato: " + nfe.getMessage());

        } catch (ArithmeticException ae) { // Es recomendable utilizar la clase especifica del posible error

            System.out.println("Hubo un error aritmético: " + ae.getMessage());

        } finally { // Bloque de código que siempre se va a ejecutar al final. Se puede usar para
                    // cerrar archivos o bases de datos

            System.out.println("El programa sigue su ejecución");

        }

        try {

            dividir(10, 0);

        } catch (DivXceroExcepcion div) {

            System.out.println("Se captura el error personalizado: " + div.getMessage());
        }

        try {

            checkContraseña("123");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static double dividir(int numerador, int dividendo) throws DivXceroExcepcion { // Se indica en el método que
                                                                                           // este puede arrojar una o
                                                                                           // mas excepciones. En este
                                                                                           // caso es una y es
                                                                                           // personalizada. Podemos
                                                                                           // seguir agregando con ",".

        if (dividendo == 0) {

            throw new DivXceroExcepcion("No se puede dividir por cero");
        }

        return numerador / dividendo;
    }

    private static void checkContraseña(String contraseña) throws Exception { // En vez de crear una excepcion arrojo el
                                                                              // padre

        if (contraseña.length() < 8) {

            throw new Exception("La contraseña tiene que contener 8 o más carácteres");
        }

    }

}
