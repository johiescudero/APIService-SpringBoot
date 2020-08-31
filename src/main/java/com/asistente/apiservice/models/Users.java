package com.asistente.apiservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class Users {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Se requiere completar el campo nombre")
    @Column(name="name",nullable=false)
    private String name;

    @NotBlank(message = "Se requiere completar el campo email")
    @Column(name="email", nullable=false, unique=true)
    private String email;
    
    @NotBlank(message = "Se requiere completar el campo password")
    @Column(name="password", nullable=false)
    private String password;

    //Constructor
    public Users(){}
    
    public int getIdUser() {
        return id;
    }

    public void setIdUser(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    
}