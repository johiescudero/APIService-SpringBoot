package com.asistente.apiservice.services;

import java.util.List;

import com.asistente.apiservice.models.Goal;
import com.asistente.apiservice.repository.GoalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {
    
    @Autowired
    private GoalRepository goalRepository;

    /** Retorna el conjunto total de objetivos registrados en la base de datos */
    public List<Goal> getGoals() {
      return goalRepository.findAll();
    }
     /**POST : Añadir nuevo subgoal */
    public void addGoal(Goal newSubGoal) {
        goalRepository.save(newSubGoal);
        
    }
    /**PUT : Actualizar un subgoal */
    public void updateGoal(Goal subGoal){
        goalRepository.save(subGoal);
    }
    /**DELETE : Eliminar un subgoal con el id */
    public void deleteGoal(Integer id){
        goalRepository.deleteById(id);
    }
}