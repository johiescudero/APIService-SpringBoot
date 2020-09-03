package com.asistente.apiservice.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "Planning")
@Table(name = "plannings")
public class Planning {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Exam exam;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Mode modo;

    private Long cantDiasReales;

    private Long cantDiasNecesarios;

    // Constructor
    public Planning() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Long getCantDiasReales() {
        return cantDiasReales;
    }

    public void setCantDiasReales(Long cantDiasReales) {
        this.cantDiasReales = cantDiasReales;
    }

    public Long getCantDiasNecesarios() {
        return cantDiasNecesarios;
    }

    public void setCantDiasNecesarios(Long cantDiasNecesarios) {
        this.cantDiasNecesarios = cantDiasNecesarios;
    }



}