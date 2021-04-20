package com.asistente.apiservice.repository;

import java.util.Optional;

import com.asistente.apiservice.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
    
    //Es una cláusula where en springboot 
    //Select * FROM USER WHERE NAME = name
    //Utilizado para a través de la configuración de Spring security obtener un usuario
    Users findByName(String name);


    Users findByEmail(String name);

  
    Optional<Users> findById(Integer id);


}