package com.asistente.apiservice.controllers;

import java.util.List;

import com.asistente.apiservice.models.FinalExam;
import com.asistente.apiservice.services.FinalExamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/exams")
public class FinalExamController {

      @Autowired
      private FinalExamService finalExamService; 

    /** Retorna el conjunto total de finales registrados en la base de datos */
     @RequestMapping(value = "/all", method = RequestMethod.GET)
     public List<FinalExam> getFinales(){
       return finalExamService.getFinales();
     }

     /**POST : Añadir nuevo final */
    @RequestMapping(value = "/addFinalExam", method = RequestMethod.POST)
    public void addFinalTest(@RequestBody FinalExam newFinalTest) {
      finalExamService.addFinalTest(newFinalTest);
        
    }
    /**PUT : Actualizar un final */
    @RequestMapping(value = "/updateExam", method = RequestMethod.PUT)
    public void updateFinalTest(@RequestBody FinalExam user){
      finalExamService.updateFinalTest(user);
    }
    /**DELETE : Eliminar un final con el id */
    @RequestMapping(value = "/deleteFinalTest/{id}", method = RequestMethod.DELETE)
    public void deleteFinalTest(@PathVariable ("id") Integer id){
      finalExamService.deleteFinalTest(id);
    }
}