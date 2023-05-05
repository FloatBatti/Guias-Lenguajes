package com.agusbatti.archivos;

public class Archivo {

    public static void main(String[] args) {

        String rutaArchivo = "D:\\Usuarios\\Agustin Battisti\\Documentos\\Guias Udemy\\" +
                "Guia Java\\src\\com\\agusbatti\\archivos\\java.txt";

        ArchivoService.archivoPrintWriter(rutaArchivo);

        System.out.println(ArchivoService.leerArchivoScanner(rutaArchivo));
    }
}
