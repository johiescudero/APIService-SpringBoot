package com.asistente.apiservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "plannings")
public class Planning {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true)
    private int id;

    @ManyToOne(targetEntity = Exam.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "idFinal", referencedColumnName = "id")
    private int idFinal;
    
    @NotBlank(message = "Se requiere completar el campo modo")
    @Column(name="modo", nullable=false)
    private String modo;

    private int cantDiasEstimados;

    //Constructor
    public Planning(){}
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

    public int getCantDiasEstimados() {
        return cantDiasEstimados;
    }

    public void setCantDiasEstimados(int cantDiasEstimados) {
        this.cantDiasEstimados = cantDiasEstimados;
    }

}