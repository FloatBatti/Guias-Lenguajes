package org.agusbatti.java;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;

public class PoolConexiones {

    private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
    private static String username= "root";
    private static String password = "Socrates426850";
    private static BasicDataSource basicDataSource;

    public static BasicDataSource getInstance() throws SQLException {

        /*
            BasicDataSource es una clase que se encarga de manejar las conexiones a la base de datos.
            Se debe agregar la dependencia de Apache Commons DBCP en el archivo pom.xml.
            Con esta clase se puede configurar el pool de conexiones. Un pool de conexiones es un conjunto de
            conexiones a la base de datos que se pueden reutilizar. En vez de crear una conexión cada vez que se
            necesite, se puede reutilizar una conexión que ya existe en el pool. El pool de conexiones se encarga
            de administrar las conexiones y de crear nuevas conexiones cuando sea necesario.

         */

        if(basicDataSource == null) {

            basicDataSource = new BasicDataSource();
            basicDataSource.setUrl(url);
            basicDataSource.setUsername(username);
            basicDataSource.setPassword(password);

            // Se configura el tamaño del pool de conexiones.

            // setInitialSize() configura el número de conexiones que se crean cuando se crea el pool de conexiones.
            basicDataSource.setInitialSize(5);

            // setMaxTotal() configura el número máximo de conexiones que puede haber en el pool.
            basicDataSource.setMaxTotal(10);

            // setMaxIdle() configura el número máximo de conexiones que pueden estar inactivas en el pool.
            basicDataSource.setMaxIdle(5);

            // setMinIdle() configura el número mínimo de conexiones que pueden estar inactivas en el pool.
            basicDataSource.setMinIdle(5);

            // setMaxWaitMillis() configura el tiempo máximo que se espera para obtener una conexión del pool.
            // Si no hay conexiones disponibles, se espera hasta que haya una conexión disponible o hasta que se
            // cumpla el tiempo máximo.
            basicDataSource.setMaxWaitMillis(5000); // 5 segundos
        }

        return basicDataSource;
        /*
            Para crear una conexión se utiliza el método getConnection() de la clase BasicDataSource:

            Connection connection = basicDataSource.getConnection();

            Para cerrar una conexión se utiliza el método close() de la clase Connection:

            connection.close();

         */
    }

    public static Conexion getConexion() throws SQLException {

        // Se obtiene una conexión desde el pool de conexiones.
        return (Conexion) getInstance().getConnection();
    }
}
