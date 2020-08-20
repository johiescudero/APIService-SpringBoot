package com.asistente.apiservice.controllers;

import java.util.List;

import com.asistente.apiservice.models.FinalTest;
import com.asistente.apiservice.repository.FinalTestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exams")
public class FinalTestController {

    @Autowired
    private FinalTestRepository repositorio;
    
    /**Retorna el conjunto total de finales registrados en la base de datos */
    @RequestMapping(value ="/all")
     public List<FinalTest> getFinales(){
       return repositorio.findAll();
       
     }

     /**POST : Añadir nuevo final */
    @PostMapping
    public void addFinalTest(@RequestBody FinalTest newFinalTest) {
      repositorio.save(newFinalTest);
        
    }
    /**PUT : Actualizar un final */
    @PutMapping
    public void updateFinalTest(@RequestBody FinalTest user){
      repositorio.save(user);
    }
    /**DELETE : Eliminar un final con el id */
    @DeleteMapping(value = "/{id}")
    public void deleteFinalTest(@PathVariable ("id") Integer id){
      repositorio.deleteById(id);
    }
}