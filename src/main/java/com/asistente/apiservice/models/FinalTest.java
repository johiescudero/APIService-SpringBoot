package com.asistente.apiservice.models;

import java.util.Date;
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
@Table(name = "FinalTests")
public class FinalTest {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne(targetEntity = Users.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private int idUser;
    
    @NotBlank(message = "Se requiere completar el campo materia")
    private String materia;
    
    @NotBlank(message = "Se requiere completar el campo fecha inicio")
    private Date inicioEstudioDate;
    
    @NotBlank(message = "Se requiere completar el campo fecha final")
    private Date finalTestDate;
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

        
}