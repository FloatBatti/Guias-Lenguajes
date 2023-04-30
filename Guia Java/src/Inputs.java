

import javax.swing.*;
import java.util.Scanner;

public class Inputs {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);  // Le indicamos que va a recibir datos por consola;

        String nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre");

        System.out.println("Ingrese su apellido: ");

        String apellido = scan.nextLine();

        scan.close();

        System.out.println("Nombre completo: " + nombre + " " + apellido);

    }
}