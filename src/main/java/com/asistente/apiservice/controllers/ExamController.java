package com.asistente.apiservice.controllers;

import java.util.List;

import com.asistente.apiservice.models.Exam;
import com.asistente.apiservice.services.ExamService;

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
@RequestMapping(value ="/exams")
public class ExamController {

    @Autowired
    private ExamService finalExamService; 
   
    /** Retorna el conjunto total de finales registrados en la base de datos */
    @GetMapping(value = "/all")
    public List<Exam> getFinales() {
       return finalExamService.getFinales();
     }

     /** Retorna el conjunto total de finales registrados en la base de datos */
    @GetMapping(value = "/{id}")
    public Exam getExamByID(@PathVariable ("id") Integer id) {
       return finalExamService.getExamById(id);
     }

     /**POST : Añadir nuevo final */
    @PostMapping(value = "/add")
    public Exam addFinalTest(@RequestBody Exam newFinalTest) {
      return finalExamService.addFinalTest(newFinalTest);        
    }
    
    /**PUT : Actualizar un final */
    @PutMapping(value = "/update/{id}")
    public void updateFinalTest(@RequestBody Exam user){
      finalExamService.updateFinalTest(user);
    }
    /**DELETE : Eliminar un final con el id */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteFinalTest(@PathVariable ("id") Integer id){
      finalExamService.deleteFinalTest(id);
    }

  }