package com.asistente.apiservice.controllers;

import com.asistente.apiservice.models.SubGoal;
import com.asistente.apiservice.repository.GoalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goals")
public class GoalController {

    @Autowired
    private GoalRepository repositorio;

     /**POST : Añadir nuevo subgoal */
    @PostMapping
    public void addGoal(@RequestBody SubGoal newSubGoal) {
      repositorio.save(newSubGoal);
        
    }
    /**PUT : Actualizar un subgoal */
    @PutMapping
    public void updateGoal(@RequestBody SubGoal subGoal){
      repositorio.save(subGoal);
    }
    /**DELETE : Eliminar un subgoal con el id */
    @DeleteMapping(value = "/{id}")
    public void deleteGoal(@PathVariable ("id") Integer id){
      repositorio.deleteById(id);
    }
    
}