package com.asistente.apiservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id",nullable=false, unique=true)
    private int id;
    @Column(name="name", nullable=false, unique=false)
    private String name;
    @Column(name="email", nullable=false, unique=true)
    private String email;
    @Column(name="password", nullable=false, unique=false)
    private String password;

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