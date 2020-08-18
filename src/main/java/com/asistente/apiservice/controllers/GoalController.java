package com.asistente.apiservice.controllers;

import java.util.List;

import com.asistente.apiservice.models.SubGoal;
import com.asistente.apiservice.repository.GoalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoalController {

    @Autowired
    private GoalRepository repositorio;

    /**Retorna el conjunto total de objetivos registrados en la base de datos */
    @GetMapping("/goals")
     public List<SubGoal> listar(){
       return repositorio.findAll();
       
     }
    
}