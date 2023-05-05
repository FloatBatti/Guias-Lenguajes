package com.agusbatti.archivos;

import java.io.*;
import java.util.Scanner;

public class ArchivoService {

    private ArchivoService() {

    }

    public static void archivoFileWriter(String path) {

        File file = new File(path);

        try {

            // FileWriter es una clase que permite escribir en un archivo, recibiendo un objeto File como parámetro.
            // Si el archivo no existe, lo crea. Si el archivo existe, lo sobreescribe.
            // Para que no lo sobreescriba, se pone true como segundo parámetro en el constructor de FileWriter.
            FileWriter writer = new FileWriter(file, true);

            // append es un método de FileWriter que permite escribir en el archivo.
            // Cada vez que se invoca el método append, se escribe en el disco. Si se tienen 1000 invocaciones
            // de append, se escribirá 1000 veces en el disco. No es tan eficiente.
            // El método append se puede concatenar ya que retorna la misma instancia.
            writer.append("Hola mundo con FileWriter!" + "\n").append("Soy la clase básica para crear y escribir archivos");

            // close() es un método de FileWriter que cierra el archivo.
            // Si no se escribe el .close() el archivo no se escribe.
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void archivoBufferdWriter(String path) {

        File file = new File(path);

        try {

            // BufferedWriter funciona igual que FileWriter, pero es más eficiente, ya que no escribe en el disco
            // cada vez que se invoca el método append, sino que va acumulando en el buffer las escrituras
            // hasta que se llene. Una vez llenado el buffer se escribe en el disco.
            // La efeciencia se nota cuando se tienen muchas escrituras en el archivo.
            // Se le pasa como parámetro un objeto FileWriter.

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));

            bufferedWriter.append("Hola mundo con BufferedWriter!" + "\n");

            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void archivoPrintWriter(String path) {

        File file = new File(path);

        try {

            // PrintWriter tambien utiliza un buffer y agrega métodos para dar formato a la escritura.
            // Es como escribir en la consola con System.out.println().
            // Tambien se le pasa como parámetro un objeto FileWriter.

            PrintWriter buffer = new PrintWriter(new FileWriter(file, true));

            // El método println() no puede concatenarse como append, ya que retorna void.
            buffer.println("Hola mundo con PrintWriter!");
            // El método printf() es similar al System.out.printf(), permitiendo dar formato a la escritura.
            buffer.printf("Hoy es el año %d \n", 2021);

            buffer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String leerArchivoReader(String path){

        File file = new File(path);

        StringBuilder builder = new StringBuilder();

        // BufferedReader es una clase que permite leer un archivo. Se le pasa como parámetro un objeto FileReader.
        // FileReader es una clase que permite leer un archivo. Se le pasa como parámetro un objeto File.
        // Si el archivo no existe, lanza una excepción.

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            // El método readLine() lee una línea del archivo y la retorna como String.
            // Si no hay más líneas para leer, retorna null.

            String linea;

            while ((linea = bufferedReader.readLine()) != null) {

                builder.append(linea).append("\n");
            }

            bufferedReader.close();

        }catch (IOException e) {

            throw new RuntimeException(e);
        }

        return builder.toString();

    }

    public static String leerArchivoScanner(String path){

        File file = new File(path);
        StringBuilder builder = new StringBuilder();

        try {

            // Scanner tambien se usa para leer archivos proporcionando una amplia variedad de métodos de
            // análisis sintáctico para leer datos de entrada en diferentes formatos, como enteros, flotantes,
            // booleanos y caracteres.
            // Se le pasa como parámetro un objeto FileReader.

            // Si se necesita leer grandes cantidades de datos, es mejor usar BufferedReader. Sin embargo, si se
            // necesita analizar y procesar los datos de entrada en diferentes formatos y estructuras, entonces
            // Scanner es la mejor opción.


            Scanner scanner = new Scanner(file);

            // El método hasNextLine() retorna true si hay una línea para leer, y false si no hay más líneas
            // para leer.
            while (scanner.hasNextLine()) {

                String linea = scanner.nextLine();

                builder.append(linea).append("\n");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return builder.toString();
    }
}
