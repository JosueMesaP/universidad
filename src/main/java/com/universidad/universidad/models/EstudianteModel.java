package com.universidad.universidad.models;

import jakarta.persistence.*;

@Entity
@Table(name = "estudiante")
public class EstudianteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;
    @Column
    private String carnet;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String semestre_ingreso;

    @Column
    private float promedio;

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
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

    public String getSemestre_ingreso() {
        return semestre_ingreso;
    }

    public void setSemestre_ingreso(String semestre_ingreso) {
        this.semestre_ingreso = semestre_ingreso;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }
}