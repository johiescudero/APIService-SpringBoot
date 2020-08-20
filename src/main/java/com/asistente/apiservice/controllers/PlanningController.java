package com.asistente.apiservice.controllers;

import java.util.Date;
import java.util.List;

import com.asistente.apiservice.models.FinalTest;
import com.asistente.apiservice.models.Planning;
import com.asistente.apiservice.models.SubGoal;
import com.asistente.apiservice.repository.GoalRepository;
import com.asistente.apiservice.repository.PlanningRepository;

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
@RequestMapping("/plannings")
public class PlanningController {
    
    @Autowired
    private PlanningRepository planningRepository;
    @Autowired
    private GoalRepository goalRepository;

    /**GET : Retorna el conjunto total de planificaciones registrados en la base de datos */
    @GetMapping
    public List<Planning> listarPlanificaciones(){
      return planningRepository.findAll();
      
    }

    /**POST : Crear y guardar una nueva planificación a partir de los datos del final y el modo indicado */
   @PostMapping
   public String crearPlanificacion(@RequestBody FinalTest finalTest, String modo) {
       Planning newPlanning = new Planning();
       long cantDiasReales = getCantDiasReales(finalTest);
       List<SubGoal> objetivosFinal = goalRepository.findByIdFinal(finalTest.getId());
       int cantDiasNecesarios = getCantDiasPorTema(modo,objetivosFinal.size());

       if (cantDiasNecesarios<=cantDiasReales){
           newPlanning.setIdFinal(finalTest.getId());
           newPlanning.setModo(modo);
           planningRepository.save(newPlanning);
           return "Se puedo guardar la planificacion";
       }
       else
        return "ERROR: No es posible crear una planificacion";   
         
   }

   //METODO: Obtiene la cantidad de días entre dos fechas => Objetivo: calcular la cantida de días reales para estudiar.
   private long getCantDiasReales(FinalTest finalTest){
        Date fechaInicioEstudio = finalTest.getInicioEstudioDate();
        Date fechaFinal = finalTest.getFinalTestDate();
        long diferencia = fechaFinal.getTime() - fechaInicioEstudio.getTime();
        long days = diferencia / (24*60*60*1000);
       return days;
   }

   private int getCantDiasPorTema(String modo, int cantTemas){
       int cantDiasPorTema;
       //Si el modo es estandar ==> Cantidad de días por tema = 4 
       if (modo.compareTo("Estandar")==0)
            cantDiasPorTema= 4;
        else
            cantDiasPorTema= 2;
        return Math.round(cantTemas/cantDiasPorTema);
   }


   /**PUT : Actualizar una planificación */
   @PutMapping
   public void modificar(@RequestBody Planning planificacion){
       planningRepository.save(planificacion);
   }

   /**DELETE : Eliminar un usuario con el id */
   @DeleteMapping(value = "/{id}")
   public void eliminar(@PathVariable ("id") Integer id){
      planningRepository.deleteById(id);
   }
}