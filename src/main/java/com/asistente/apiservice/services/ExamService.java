package com.asistente.apiservice.services;
import java.util.List;

import com.asistente.apiservice.models.Exam;
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
    finalExamRepository.deleteById(id);
   }

  
}