package com.asistente.apiservice.repository;

import com.asistente.apiservice.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
    
    //Es una cláusula where en springboot 
    //SELECT * FROM USER WHERE NOMBRE = nombre
    Users findByName(String name);
}