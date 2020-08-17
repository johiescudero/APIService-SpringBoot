package com.asistente.apiservice.controllers;

import java.util.List;

import com.asistente.apiservice.models.Users;

import com.asistente.apiservice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personas")
public class DemoController {

    @Autowired
    private IUserRepository userRepository;
    
    @GetMapping
    public List<Users> listar(){
      return userRepository.findAll();
      
    }
    
   
}