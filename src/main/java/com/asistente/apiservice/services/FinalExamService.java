package com.asistente.apiservice.services;

import java.util.List;

import com.asistente.apiservice.models.FinalExam;
import com.asistente.apiservice.repository.FinalExamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinalExamService {
    
    @Autowired
    private FinalExamRepository finalExamRepository;

    /** Retorna el conjunto total de finales registrados en la base de datos */
    public List<FinalExam> getFinales(){
      return finalExamRepository.findAll();
    }

    /**POST : Añadir nuevo final */
   public void addFinalTest(FinalExam newFinalTest) {
    finalExamRepository.save(newFinalTest);
       
   }
   /**PUT : Actualizar un final */
   public void updateFinalTest(FinalExam finalExam){
    finalExamRepository.save(finalExam);
   }
   /**DELETE : Eliminar un final con el id */
   public void deleteFinalTest(Integer id){
    finalExamRepository.deleteById(id);
   }
}