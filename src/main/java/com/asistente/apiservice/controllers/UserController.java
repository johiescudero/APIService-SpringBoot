package com.asistente.apiservice.controllers;

import java.util.List;

import com.asistente.apiservice.models.Users;
import com.asistente.apiservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    /**Retorna el conjunto total de usuarios registrados en la base de datos */
    @GetMapping("/users")
    public List<Users> listar(){
      return userRepository.findAll();
      
    }
    
}