package com.asistente.apiservice.controllers;

import java.util.List;

import com.asistente.apiservice.models.FinalExam;
import com.asistente.apiservice.models.Planning;
import com.asistente.apiservice.services.PlanningService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/plannings")
public class PlanningController {
    
    @Autowired
    private PlanningService planningService;

    /**GET : Retorna el conjunto total de planificaciones registrados en la base de datos */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Planning> listarPlanificaciones(){
      return planningService.listarPlanificaciones();
      
    }

    /**POST : Crear y guardar una nueva planificación a partir de los datos del final y el modo indicado */
    @RequestMapping(value = "/addPlanning", method = RequestMethod.POST)
    public String crearPlanificacion(@RequestBody FinalExam finalTest, String modo) { 
        return planningService.crearPlanificacion(finalTest, modo);
    }

   /**PUT : Actualizar una planificación */
   @RequestMapping(value = "/updatePlanning", method = RequestMethod.PUT)
   public void modificar(@RequestBody Planning planificacion){
        planningService.modificar(planificacion);
   }

   /**DELETE : Eliminar un usuario con el id */
   @RequestMapping(value = "/deletePlanning/{id}", method = RequestMethod.DELETE)
   public void eliminar(@PathVariable ("id") Integer id){
        planningService.eliminar(id);
   }
}