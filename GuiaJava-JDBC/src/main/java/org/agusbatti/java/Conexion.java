package org.agusbatti.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
    private static String username= "root";
    private static String password = "Socrates426850";
    private static Connection connection;

    public static Connection getInstance() throws SQLException {

        if(connection == null) {
            // DriverManager es una clase que se encarga de manejar las conexiones a la
            // base de datos.
            connection = DriverManager.getConnection(url, username, password);
        }

        return connection;
    }

}
