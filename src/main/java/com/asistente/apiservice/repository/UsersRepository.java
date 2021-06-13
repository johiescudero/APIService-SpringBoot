package com.asistente.apiservice.repository;

import com.asistente.apiservice.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Integer> {
       
    //Es una cláusula where en springboot 
    //Select * FROM USER WHERE NAME = name
    Users findByName(String name);


    Users findByEmail(String email);

}