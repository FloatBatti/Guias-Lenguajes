package org.agusbatti.java.repositorio;

import org.agusbatti.java.Conexion;
import org.agusbatti.java.models.Categoria;
import org.agusbatti.java.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepo implements Repositorio<Producto>{

    private Connection getConnection() throws SQLException {
        return Conexion.getInstance();
    }

    @Override
    public List<Producto> listar() {

        List<Producto> productos = new ArrayList<>();

        // Al poner la conexión dentro del try, nos aseguramos que se cierre, sin tener que hacerlo manualmente.
        try(Statement statement = this.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery("select p.*, c.nombre as categoria from productos p inner join categorias c on p.id_categoria = c.id_categoria")) {

            while (resultSet.next()) {

                Producto producto = crearProducto(resultSet);

                productos.add(producto);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return productos;
    }

    @Override
    public Producto buscarPorId(int id) {

        Producto producto = null;

        // Se utiliza PreparedStatement para evitar SQL Injection. En este caso no es necesario. A diferencia de
        // Statement, PreparedStatement se compila antes de ejecutarse, lo que permite ingresar parámetros.
        try(PreparedStatement preparedStatement =
                    this.getConnection().prepareStatement("select p.*, c.nombre as categoria from productos p inner join categorias c on p.id_categoria = c.id_categoria WHERE id_producto = ?")) {

            preparedStatement.setInt(1, id);

            // Se usa executeQuery() para sentencias SELECT.
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                producto = crearProducto(resultSet);
            }

            // Tengo que cerrar el ResultSet, ya que no lo estoy haciendo dentro del try.
            resultSet.close();

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
            sql = "INSERT INTO productos (nombre, precio, fecha_registro) VALUES (?, ?, ?)";
        } else {
            sql = "UPDATE productos SET nombre = ?, precio = ?, fecha_registro = ? WHERE id_producto = ?";
        }

        try(PreparedStatement preparedStatement = this.getConnection().prepareStatement(sql)) {

            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setDouble(2, producto.getPrecio());
            // Se usa el Date de java.sql, no el de java.util.
            // Se usa getTime() para obtener el valor en milisegundos.

            // Si el id es distinto de 0, significa que es un producto existente, por lo que le tengo que
            // pasar el mismo id que tenía. No le agrego la fecha de registro, ya que no se puede modificar.
            if(producto.getId() != 0){

                preparedStatement.setInt(4, producto.getId());

            }else{  // Si el id es 0, significa que es un nuevo producto, por lo que no le tengo que pasar
                    // el id, ya que se genera automáticamente.

                preparedStatement.setDate(3, new Date(producto.getFechaRegistro().getTime()));
            }


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

        }
    }

    @Override
    public void actualizar(Producto producto) {

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
