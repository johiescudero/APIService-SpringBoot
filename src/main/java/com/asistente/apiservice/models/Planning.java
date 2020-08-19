package com.asistente.apiservice.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Planning {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true)
    private int id;

    @ManyToOne(targetEntity = FinalTest.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "idFinal", referencedColumnName = "id")
    private int idFinal;
    
    @Column(name="modo", nullable=false, unique=false)
    @NotBlank(message = "Se requiere completar el campo modo")
    private String modo;

    @Column(name="planificacion", nullable=false, unique=true)
    private List<String> planificacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdFinal() {
        return idFinal;
    }

    public void setIdFinal(int idFinal) {
        this.idFinal = idFinal;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public List<String> getPlanificación() {
        return planificacion;
    }

    public void setPlanificación(List<String> planificacion) {
        this.planificacion = planificacion;
    }
}