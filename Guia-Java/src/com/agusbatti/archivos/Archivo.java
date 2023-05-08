package com.agusbatti.archivos;

import java.io.File;

public class Archivo {

    public static void main(String[] args) {

        File file = new File("src/com/agusbatti/archivos/java.txt");

        // Métodos más importantes de File:

        /*
            - String getName() -> Retorna el nombre del archivo
            - String getPath() -> Retorna la ruta del archivo
            - boolean exists() -> Retorna true si el archivo existe
            - boolean canWrite() -> Retorna true si el archivo se puede escribir
            - boolean canRead() -> Retorna true si el archivo se puede leer
            - boolean isFile() -> Retorna true si el archivo es un archivo
            - boolean isDirectory() -> Retorna true si el archivo es un directorio
            - long lastModified() -> Retorna la fecha de la última modificación del archivo
            - boolean renameTo(File dest) -> Renombra el archivo
            - boolean delete() -> Elimina el archivo
            - String[] list() -> Retorna un array de String con los nombres de los archivos y directorios que contiene
             el directorio
            - boolean mkdir() -> Crea un directorio
            - boolean mkdirs() -> Crea un directorio y los directorios que no existan en la ruta
            - boolean createNewFile() -> Crea un archivo
            - boolean isHidden() -> Retorna true si el archivo está oculto
            - long length() -> Retorna el tamaño del archivo en bytes
         */

        // La diferencia entre directorio y archivo es que el directorio es un archivo que contiene otros archivos.
        // Los direc
        File directorio = new File("src/com/agusbatti/archivos/directorio");

        String rutaArchivo = "src/com/agusbatti/archivos/java.txt";

        //ArchivoService.archivoPrintWriter(rutaArchivo);

        ArchivoService.archivoBufferdWriter(rutaArchivo);

        //System.out.println(ArchivoService.leerArchivoScanner(rutaArchivo));
    }
}
