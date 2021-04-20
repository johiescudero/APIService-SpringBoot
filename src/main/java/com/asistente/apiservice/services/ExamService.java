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

    /** Retorna el conjunto total de finales registrados en la base de datos */
    public List<Exam> getFinales() {
      return finalExamRepository.findAll();
    }

    /** Retorna el conjunto total de finales registrados en la base de datos */
    public List<Exam> getMisFinales(Users user) {
      return finalExamRepository.findByUsuario(user);
    }

    /**POST : Añadir nuevo final */
   public void addFinalTest(Exam newFinalTest) {
    finalExamRepository.save(newFinalTest);
       
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