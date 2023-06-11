package com.guiahibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@Embeddable // Indica que esta clase se va a utilizar como una clase embebida en otra clase, es decir, que esta clase
// se va a utilizar como un atributo en otra clase y no como una entidad. Seria como agregar un pequeño fragmento de
// código en otra clase. En este caso, se va a utilizar en las clases que se quieran auditar, es decir, que se quiera
// saber cuando se creó y cuando se editó un registro.
// El objetivo es crear una clase que se pueda utilizar en varias entidades para que se pueda reutilizar el código.
public class Auditoria {

    @Column(name = "creado_en")
    private LocalDateTime creadoEn;
    @Column(name = "editado_en")
    private LocalDateTime editadoEn;

    // También se pueden utilizar las notaciones @PostPersist y @PostUpdate para ejecutar un método después de
    // persistir. Luego tenemos para remover, refrescar y cargar, @PostRemove, @PostRefresh y @PostLoad respectivamente.

    @PrePersist // Esta anotación indica que se va a ejecutar este método antes de persistir la entidad.
    public void prepPersist() {
        System.out.println("Se pone la fecha antes de agregar el registro");
        this.creadoEn = LocalDateTime.now();
    }

    @PreUpdate // Esta anotación indica que se va a ejecutar este método antes de actualizar la entidad.
    public void preUpdate() {
        System.out.println("Se pone la fecha antes de actualizar el registro");
        this.editadoEn = LocalDateTime.now();
    }

    // region Getters y setters

    public LocalDateTime getCreadoEn() {
        return this.creadoEn;
    }

    public void setCreadoEn(LocalDateTime creadoEn) {
        this.creadoEn = creadoEn;
    }

    public LocalDateTime getEditadoEn() {
        return this.editadoEn;
    }

    public void setEditadoEn(LocalDateTime editadoEn) {
        this.editadoEn = editadoEn;
    }

    // endregion

}
