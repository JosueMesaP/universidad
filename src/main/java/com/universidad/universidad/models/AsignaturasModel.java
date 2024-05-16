package com.universidad.universidad.models;

import jakarta.persistence.*;

@Entity
@Table(name = "asignaturas")
public class AsignaturasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAsignatura;

    @Column
    private String nombreAsignatura;

    @Column
    private Long intensidadSemanal;

    @Column
    private Long semestre;

    public Long getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Long idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public Long getIntensidadSemanal() {
        return intensidadSemanal;
    }

    public void setIntensidadSemanal(Long intensidadSemanal) {
        this.intensidadSemanal = intensidadSemanal;
    }

    public Long getSemestre() {
        return semestre;
    }

    public void setSemestre(Long semestre) {
        this.semestre = semestre;
    }
}
