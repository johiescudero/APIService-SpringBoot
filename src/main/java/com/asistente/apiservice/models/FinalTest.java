package com.asistente.apiservice.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FinalTests")
public class FinalTest {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id", length=50, nullable=false, unique=true)
    private int id;

    @ManyToOne(targetEntity = Users.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser", referencedColumnName = "id")
    private int idUser;
    
    @Column(name="materia", length=50, nullable=false, unique=false)
    private String materia;
    
    @Column(name="inicioEstudioDate", length=50, nullable=false, unique=false)
    private Date inicioEstudioDate;
    
    @Column(name="finaltestDate", length=50, nullable=false, unique=false)
    private Date finalTestDate;
    
    @Column(name="modo", length=50, nullable=false, unique=false)
    private String modo;

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

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }
    
}