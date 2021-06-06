package com.asistente.apiservice.services;

import java.util.ArrayList;
import java.util.List;

import com.asistente.apiservice.models.Exam;
import com.asistente.apiservice.models.Goal;
import com.asistente.apiservice.repository.ExamRepository;
import com.asistente.apiservice.repository.GoalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {
    
    @Autowired
    private GoalRepository goalRepository;
    @Autowired
    private ExamRepository examRepository;

    /** Retorna el conjunto total de objetivos registrados en la base de datos */
    public List<Goal> getGoals() {
      return goalRepository.findAll();
    }

     /**GET : Retorna el conjunto total de Goals asociados con un Examen Final */
     public List<Goal> getGoalsByExamId(Integer idExam) {
        Exam exam = examRepository.findById(idExam).get();
        List<Goal> allGoals = this.getGoals();
        List<Goal> goalsAsociados = new ArrayList<Goal>();
        for (Goal goal: allGoals){
            if (goal.getExam().equals(exam))
              goalsAsociados.add(goal);

        }
        return goalsAsociados;
    }
    
    /**POST : Añadir nuevo subgoal */
    public Goal addGoal(Goal newSubGoal) {
        return goalRepository.save(newSubGoal);
        
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