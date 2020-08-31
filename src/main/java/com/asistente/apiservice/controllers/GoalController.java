package com.asistente.apiservice.controllers;

import java.util.List;

import com.asistente.apiservice.models.Goal;
import com.asistente.apiservice.services.GoalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    /** Retorna el conjunto total de objetivos registrados en la base de datos */
    @GetMapping(value = "/all")
    public List<Goal> getGoals(){
      return goalService.getGoals();
    }
     /**POST : Añadir nuevo subgoal */
    @PostMapping(value = "/add")
    public void addGoal(@RequestBody Goal newSubGoal) {
      goalService.addGoal(newSubGoal);
        
    }
    /**PUT : Actualizar un subgoal */
    @PutMapping(value = "/update/{id}")
    public void updateGoal(@RequestBody Goal subGoal){
      goalService.updateGoal(subGoal);
    }
    /**DELETE : Eliminar un subgoal con el id */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteGoal(@PathVariable ("id") Integer id){
      goalService.deleteGoal(id);
    }
    
}