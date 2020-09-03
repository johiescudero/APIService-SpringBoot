package com.asistente.apiservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity(name = "Planning")
@Table(name = "plannings")
public class Planning {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Exam exam;
    
    @NotBlank(message = "Se requiere completar el campo modo")
    @OneToOne
    @PrimaryKeyJoinColumn
    private Mode modo;

    private int cantDiasEstimados;

    //Constructor
    public Planning(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantDiasEstimados() {
        return cantDiasEstimados;
    }

    public void setCantDiasEstimados(int cantDiasEstimados) {
        this.cantDiasEstimados = cantDiasEstimados;
    }

    public Mode getModo() {
        return modo;
    }

    public void setModo(Mode modo) {
        this.modo = modo;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

}