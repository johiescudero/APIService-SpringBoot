package com.asistente.apiservice.services;

import java.util.Date;
import java.util.List;

import com.asistente.apiservice.models.Exam;
import com.asistente.apiservice.models.Planning;
import com.asistente.apiservice.models.Goal;
import com.asistente.apiservice.models.Mode;
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
     public Planning crearPlanificacion(Exam finalTest, Mode modo) {
        //Creo la planificación
        Planning newPlanning = new Planning();
        //Calculo la cantidad de días reales que se tienen para rendir el final
        long cantDiasReales = getCantDiasReales(finalTest);
        //Calculo la cantidad de días necesarios de acuerdo al modo ingresado
        List<Goal> objetivosFinal = goalRepository.findByExam(finalTest);
        long cantDiasNecesarios = getCantDiasPorTemaNecesarios(modo,objetivosFinal.size());
 
        //Compara las dos entradas --> return 0 si son iguales
        //                             return <0 si cantDiasNecesarios < cantDiasReales
        if (Long.compare(cantDiasNecesarios, cantDiasReales)<=0){
            newPlanning.setExam(finalTest);
            newPlanning.setModo(modo);
            newPlanning.setCantDiasNecesarios(cantDiasNecesarios);
            newPlanning.setCantDiasReales(cantDiasReales);
            return planningRepository.save(newPlanning);
        }
        else
            return null;          
    }
 
    //METODO: Obtiene la cantidad de días entre dos fechas => Objetivo: calcular la cantidad de días reales para estudiar.
    public long getCantDiasReales(Exam finalTest){
         Date fechaInicioEstudio = finalTest.getInicioEstudioDate();
         Date fechaFinal = finalTest.getFinalTestDate();
         long diferencia = fechaFinal.getTime() - fechaInicioEstudio.getTime();
         long days = diferencia / (24*60*60*1000);
        return days - 1;
    }
    //METODO: Obtiene la cantidad de días NECESARIOS para estudiar todos los temas -> tiene en cuenta el modo
     public int getCantDiasPorTemaNecesarios(Mode modo, int cantTemas){
        int cantDiasPorTema;
        //Si el modo es estandar ==> Cantidad de días por tema = 4 
        if ((modo.getModo()).compareTo("Estándar")==0)
             cantDiasPorTema= 4;
         else
             cantDiasPorTema= 2;
         return Math.round(cantTemas*cantDiasPorTema);
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