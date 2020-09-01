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

@Entity(name = "Goal")
@Table(name = "goals")
public class Goal {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Exam.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "idFinal", referencedColumnName = "id")
    private int idFinal;

    @NotBlank(message = "Se requiere completar el campo objetivo")
    @Column(name = "objetivo", nullable = false) 
    private String objetivo;

    //Constructor
    public Goal(){}
    
    public int getId() {
        return id;
    }

    public void setId(int idGoal) {
        this.id = idGoal;
    }

    public int getIdFinal() {
        return idFinal;
    }

    public void setIdFinal(int idFinal) {
        this.idFinal = idFinal;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

}