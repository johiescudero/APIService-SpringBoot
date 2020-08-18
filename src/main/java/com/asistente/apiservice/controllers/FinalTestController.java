package com.asistente.apiservice.controllers;

import java.util.List;

import com.asistente.apiservice.models.FinalTest;
import com.asistente.apiservice.repository.FinalTestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinalTestController {

    @Autowired
    private FinalTestRepository repositorio;
    
    /**Retorna el conjunto total de finales registrados en la base de datos */
    @GetMapping("/finaltests")
     public List<FinalTest> listar(){
       return repositorio.findAll();
       
     }
}