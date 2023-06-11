package com.guiahibernate.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity // Esta anotación es para indicar que esta clase es una entidad. Una entidad es una clase que se va a mapear
// a una tabla en la base de datos.
@Table(name = "clientes") // Indica el nombre de la tabla en la base de datos.
public class Cliente {

    @Id // Indica que el atributo es una llave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Indica que el valor de la llave primaria se va a generar
    // automáticamente, en este caso, se va a generar de forma incremental.
    private int id;
    private String nombre;
    private String apellido;
    @Column(name = "forma_pago") // Indica el nombre de la columna en la base de datos porque el nombre del atributo
    // no es igual al nombre de la columna en la base de datos.
    private String formaPago;

    @Embedded // Indica que se va a utilizar una clase embebida en esta clase.
    // Al momento de instanciar esta clase, se van a integrar los atributos de la clase embebida en esta clase.
    private Auditoria auditoria = new Auditoria();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true) // Indica que un cliente puede tener muchas direcciones.
    // CascadeType.ALL indica que se va a persistir en cascada, es decir, si se persiste un cliente, se persisten
    // todas sus entidades relacionadas, en este caso las direcciones.
    // orphanRemoval = true indica que si se elimina un cliente, se eliminan todas sus direcciones.
    @JoinColumn(name = "id_cliente") // Indica el nombre de la columna que va a relacionar las dos tablas.
    // Se crea una columna en la tabla de direcciones con el nombre de la columna indicada en esta anotación.
    // Si no se utiliza, JPA va a crear una tabla intermedia para relacionar las dos entidades. Esto es debido
    // a que el objeto Direccion no tiene una referencia al cliente. Es algo que ofrece JPA para poder
    // relacionar entidades, pero no es lo más recomendable. Lo ideal sería evitar la tabla intermedia y
    // agregar una referencia al cliente en la clase Direccion.
    private List<Direccion> direcciones;

    // region Constructores
    public Cliente() {
        direcciones = new ArrayList<>();
    }

    public Cliente(String nombre, String apellido, String formaPago) {
        this(); // Llama al constructor sin parámetros.
        this.nombre = nombre;
        this.apellido = apellido;
        this.formaPago = formaPago;
    }

    public Cliente(int id, String nombre, String apellido, String formaPago) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.formaPago = formaPago;
    }

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // endregion

    // region Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    // endregion

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", formaPago='" + formaPago + '\'' +
                // En los objetos o registros que fueron creados antes de agregar el atributo auditoria, el valor de
                // este atributo va a ser null.
                ", creadoEn=" + (auditoria != null ? auditoria.getCreadoEn() : null) + '\'' +
                ", editadoEn=" + (auditoria != null ? auditoria.getEditadoEn() : null) + '\'' +
                ", direcciones=" + direcciones + '\'' +
                '}';
    }
}
