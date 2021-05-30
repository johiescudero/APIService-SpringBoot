package com.asistente.apiservice.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "Exam")
@Table(name = "exams")
public class Exam {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", nullable=false, unique=true)
    private int id;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Users usuario;
    
    @NotBlank(message = "Se requiere completar el campo materia")
    @Column(name = "materia", nullable = false)
    private String materia;
    
    @Column(name = "inicioEstudioDate", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date inicioEstudioDate;
    
    @Column(name = "finalEstudioDate", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date finalTestDate;
  
    //Constructor
    public Exam(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public Date getInicioEstudioDate() {
        return inicioEstudioDate;
    }

    public void setInicioEstudioDate(Date inicioEstudioDate) {
        this.inicioEstudioDate = inicioEstudioDate;
    }

    public Date getFinalTestDate() {
        return finalTestDate;
    }

    public void setFinalTestDate(Date finalTestDate) {
        this.finalTestDate = finalTestDate;
    }

    public Users getUsuario() {
        return usuario;
    }

    public void setUsuario(Users usuario) {
        this.usuario = usuario;
    }

        
}