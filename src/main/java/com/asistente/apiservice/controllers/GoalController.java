package com.asistente.apiservice.controllers;

import java.util.List;

import com.asistente.apiservice.models.Goal;
import com.asistente.apiservice.services.GoalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    /** Retorna el conjunto total de objetivos registrados en la base de datos */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Goal> getGoals(){
      return goalService.getGoals();
    }
     /**POST : Añadir nuevo subgoal */
    @RequestMapping(value = "/addGoal", method = RequestMethod.GET)
    public void addGoal(@RequestBody Goal newSubGoal) {
      goalService.addGoal(newSubGoal);
        
    }
    /**PUT : Actualizar un subgoal */
    @RequestMapping(value = "/updateGoal", method = RequestMethod.PUT)
    public void updateGoal(@RequestBody Goal subGoal){
      goalService.updateGoal(subGoal);
    }
    /**DELETE : Eliminar un subgoal con el id */
    @RequestMapping(value = "/deleteGoal/{id}", method = RequestMethod.DELETE)
    public void deleteGoal(@PathVariable ("id") Integer id){
      goalService.deleteGoal(id);
    }
    
}