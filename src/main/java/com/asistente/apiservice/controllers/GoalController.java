package com.asistente.apiservice.controllers;

import java.util.List;

import com.asistente.apiservice.models.SubGoal;
import com.asistente.apiservice.repository.GoalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     /**POST : Añadir nuevo subgoal */
    @PostMapping
    public void insertar(@RequestBody SubGoal newSubGoal) {
      repositorio.save(newSubGoal);
        
    }
    /**PUT : Actualizar un subgoal */
    @PutMapping
    public void modificar(@RequestBody SubGoal subGoal){
      repositorio.save(subGoal);
    }
    /**DELETE : Eliminar un subgoal con el id */
    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable ("id") Integer id){
      repositorio.deleteById(id);
    }
    
}