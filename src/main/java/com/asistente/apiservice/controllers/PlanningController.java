package com.asistente.apiservice.controllers;

import java.util.List;
import com.asistente.apiservice.models.Mode;
import com.asistente.apiservice.models.Planning;
import com.asistente.apiservice.services.PlanningService;

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
@RequestMapping(value ="/plannings")
public class PlanningController {
    
    @Autowired
    private PlanningService planningService;

    /**GET : Retorna el conjunto total de planificaciones registrados en la base de datos */
    @GetMapping(value = "/all")
    public List<Planning> listarPlanificaciones(){
      return planningService.listarPlanificaciones(); 
    }

    /**GET : Retorna el conjunto total de planificaciones asociadas a un examen final */
    @GetMapping(value = "/all/{id}")
    public List<Planning> getPlanningsByExamId(@PathVariable ("id") Integer idExam){
      return planningService.getPlanningsByExamId(idExam);
    }
      

    /**POST : Crear y guardar una nueva planificación a partir de los datos del final y el modo indicado */
    @PostMapping(value = "/add/{idExam}")
    public Planning crearPlanificacion(@PathVariable ("idExam") Integer idExam, @RequestBody Mode modo) { 
        return planningService.crearPlanificacion(idExam, modo);
    }

   /**PUT : Actualizar una planificación */
   @PutMapping(value = "/update/{id}")
   public void modificar(@RequestBody Planning planificacion){
        planningService.modificar(planificacion);
   }

   /**DELETE : Eliminar un usuario con el id */
   @DeleteMapping(value = "/delete/{id}")
   public void eliminar(@PathVariable ("id") Integer id){
        planningService.eliminar(id);
   }
}