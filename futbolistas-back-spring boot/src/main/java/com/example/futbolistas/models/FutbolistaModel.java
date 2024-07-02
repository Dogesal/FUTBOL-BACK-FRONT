package com.example.futbolistas.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="futbolista")
public class FutbolistaModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombres;

    @Column(nullable = false)
    private String apellidos;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha_nacimiento;

    @Column(nullable = false)
    private String caracteristicas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_posicion", nullable = false)
    private PosicionModel posicion;

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public PosicionModel getPosicion() {
        return posicion;
    }

    public void setPosicion(PosicionModel posicion) {
        this.posicion = posicion;
    }
}
