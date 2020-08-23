package com.asistente.apiservice.services;

import java.util.Date;
import java.util.List;

import com.asistente.apiservice.models.FinalExam;
import com.asistente.apiservice.models.Planning;
import com.asistente.apiservice.models.SubGoal;
import com.asistente.apiservice.repository.GoalRepository;
import com.asistente.apiservice.repository.PlanningRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanningService {

    @Autowired
    private PlanningRepository planningRepository;
    @Autowired
    private GoalRepository goalRepository; 

     /**GET : Retorna el conjunto total de planificaciones registrados en la base de datos */
     public List<Planning> listarPlanificaciones() {
       return planningRepository.findAll();
       
     }
 
     /**POST : Crear y guardar una nueva planificación a partir de los datos del final y el modo indicado */
     public String crearPlanificacion(FinalExam finalTest, String modo) {
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
    private long getCantDiasReales(FinalExam finalTest){
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
    public void modificar(Planning planificacion){
        planningRepository.save(planificacion);
    }
 
    /**DELETE : Eliminar un usuario con el id */
    public void eliminar(Integer id){
       planningRepository.deleteById(id);
    }
    
}