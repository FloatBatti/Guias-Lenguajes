package org.agusbatti.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
    private static String username= "root";
    private static String password = "Socrates426850";
    private static Connection connection;

    // Se utiliza el patrón Singleton para asegurarse que solo haya una instancia de la conexión.
    // Esto es necesario porque la conexión es un recurso que se debe cerrar, y si hay más de una instancia,
    // no se puede cerrar correctamente.
    // El patrón Singleton se utiliza cuando se debe tener una conexión constante con la base de datos, pero en
    // aplicaciones donde solo se necesita una conexión en ciertos momentos, no es necesario utilizarlo.
    // Si no se utiliza el patrón Singleton, el método getInstance() solo debe retornar la conexión, sin asegurarse
    // que sea la misma instancia. Luego la conexión debe realizarse en cada método que la necesite, por ejemplo,
    // en los métodos de los repositorios.
    public static Connection getInstance() throws SQLException {

        if(connection == null) {
            // DriverManager es una clase que se encarga de manejar las conexiones a la base de datos.
            connection = DriverManager.getConnection(url, username, password);
        }

        return connection;
    }

}
