package com.guiahibernate.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Long total;

    public Factura(String descripcion, Long total) {
        this.descripcion = descripcion;
        this.total = total;
    }

    public Factura() {
    }

    @ManyToOne // Muchas facturas pueden pertenecer a un cliente. La primera palabra hace referencia a la clase
    // actual y la segunda a la clase a la que se hace referencia (el atributo).
    @JoinColumn(name = "id_cliente") // Nombre de foreign key.
    Cliente cliente;

    //region Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    //endregion


}
