package com.asistente.apiservice.services;
import java.util.List;

import com.asistente.apiservice.models.Exam;
import com.asistente.apiservice.models.Goal;
import com.asistente.apiservice.models.Planning;
import com.asistente.apiservice.models.Users;
import com.asistente.apiservice.repository.ExamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
    
    @Autowired
    private ExamRepository finalExamRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private GoalService goalService;
    @Autowired
    private PlanningService planningService;
  
    /** Retorna el conjunto total de finales registrados en la base de datos */
    public List<Exam> getFinales() {
      return finalExamRepository.findAll();
    }

    /** Retorna el conjunto total de finales registrados en la base de datos */
    public Exam getExamById(int idUser) {
      return finalExamRepository.findById(idUser).get();
    }

    /** Retorna el conjunto total de finales registrados en la base de datos */
    public List<Exam> getMisFinales(int idUser) {
        Users userLoggedIn = this.userService.getUserById(idUser);
             
        return this.finalExamRepository.findByUsuario(userLoggedIn);

   }

    /**POST : Añadir nuevo final */
   public Exam addFinalTest(int idUser, Exam newFinalTest) {
    newFinalTest.setUsuario(this.userService.getUserById(idUser)); 
    return finalExamRepository.save(newFinalTest);
       
   }
   /**PUT : Actualizar un final */
   public void updateFinalTest(Exam finalExam){
    finalExamRepository.save(finalExam);
   }
   /**DELETE : Eliminar un final con el id */
   public void deleteFinalTest(Integer id){
    List<Goal> temasAsociados = goalService.getGoalsByExamId(id);
    List<Planning> planningAsociadas = planningService.getPlanningsByExamId(id);
    
    //Elimino los goals asociados al final
    for (Goal goalAsociado: temasAsociados){
      goalService.deleteGoal(goalAsociado.getId());
    }
    //Elimino las plannings asociadas al final
    for (Planning planningAsociada: planningAsociadas){
      planningService.eliminar(planningAsociada.getId());
    }
    finalExamRepository.deleteById(id);

   }

  
}