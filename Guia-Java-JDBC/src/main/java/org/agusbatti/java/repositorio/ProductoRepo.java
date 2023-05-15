package org.agusbatti.java.repositorio;

import org.agusbatti.java.Conexion;
import org.agusbatti.java.models.Categoria;
import org.agusbatti.java.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepo implements Repositorio<Producto>{

    // En el caso de que no se utilice el patrón Singleton, se debe crear una conexión en cada método que la
    // necesite, sin necesidad de crear el método getConnection().
    // Dentro del try se crea la conexión, y al finalizar el bloque try, se cierra automáticamente.
    private Connection getConnection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public List<Producto> listar() {

        List<Producto> productos = new ArrayList<>();

        // Al poner la conexión dentro del try, nos aseguramos que se cierre, sin tener que hacerlo manualmente.
        // Se llama try-with-resources, que se encarga de cerrar los recursos automáticamente. Solo se pueden
        // poner variables que implementen AutoCloseable y no cambien su valor dentro del try, es decir, que
        // sean final o effectively final. Este último significa que no cambian su valor, aunque no sean final.
        // Statement es una clase que se encarga de ejecutar sentencias SQL.
        // ResultSet es una clase que se encarga de almacenar los resultados de una consulta.
        try(Statement statement = this.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select p.*, c.nombre as categoria from productos p inner join categorias c on p.id_categoria = c.id_categoria")) {

            while (resultSet.next()) {

                Producto producto = crearProducto(resultSet);

                productos.add(producto);
            }

        }
        catch (SQLException e) {

            // printStackTrace() imprime el stack trace de la excepción. Es útil para debuggear.
            e.printStackTrace();
        }

        return productos;
    }

    @Override
    public Producto buscarPorId(int id) {

        Producto producto = null;

        // Se utiliza PreparedStatement para evitar SQL Injection. En este caso no es necesario. A diferencia de
        // Statement, PreparedStatement se compila antes de ejecutarse, lo que permite ingresar parámetros.
        // Al compilar la sentencia, se evita que se ejecute código malicioso porque no se puede modificar.
        try(PreparedStatement preparedStatement =
                    this.getConnection().prepareStatement("select p.*, c.nombre as categoria from productos p inner join categorias c on p.id_categoria = c.id_categoria WHERE id_producto = ?")) {

            // Se usa setInt() para indicar que el parámetro es un entero. El primer parámetro es el índice del
            // parámetro, y el segundo es el valor.
            preparedStatement.setInt(1, id);

            // Se usa executeQuery() para sentencias SELECT.
            // No se puede usar el mismo try-with-resources porque se cambia el valor de preparedStatement al
            // llamar el método setInt().
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                if (resultSet.next()) {
                    producto = crearProducto(resultSet);
                }
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return producto;
    }

    @Override
    public void guardar(Producto producto) {

        String sql;

        // Si el id es 0, significa que es un nuevo producto, por lo que se usa INSERT. Si no, se usa UPDATE.
        if (producto.getId() == 0) {
            sql = "INSERT INTO productos ( id_categoria, nombre, precio, fecha_registro) VALUES (?, ?, ?, ?)";
        } else {
            sql = "UPDATE productos SET id_categoria= ? ,nombre = ?, precio = ?  WHERE id_producto = ?";
        }

        try(PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)) {

            preparedStatement.setInt(1, producto.getCategoria().getId());
            preparedStatement.setString(2, producto.getNombre());
            preparedStatement.setDouble(3, producto.getPrecio());

            // Se usa el Date de java.sql, no el de java.util.
            // Se usa getTime() para obtener el valor en milisegundos.

            // Si el id es 0, es nuevo, entonces se debe pasar la fecha de registro.
            if(producto.getId() == 0)
                preparedStatement.setDate(4, new Date(producto.getFechaRegistro().getTime()));

            else    // Si el id no es 0, es porque ya existe, entonces se debe que pasar
                    // el id que ya tiene.
                preparedStatement.setInt(4, producto.getId());

            // Se usa executeUpdate() para sentencias INSERT, UPDATE y DELETE.
            preparedStatement.executeUpdate();

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(int id) {

        try(PreparedStatement preparedStatement =
                    this.getConnection().prepareStatement("DELETE FROM productos WHERE id_producto = ?")) {

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static Producto crearProducto(ResultSet resultSet) throws SQLException {

        Producto producto = new Producto();

        producto.setId(resultSet.getInt("id_producto"));
        producto.setNombre(resultSet.getString("nombre"));
        producto.setPrecio(resultSet.getDouble("precio"));
        producto.setFechaRegistro(resultSet.getDate("fecha_registro"));

        Categoria categoria = new Categoria();
        categoria.setId(resultSet.getInt("id_categoria"));
        categoria.setNombre(resultSet.getString("categoria"));

        producto.setCategoria(categoria);

        return producto;
    }
}
