package com.asistente.apiservice.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.asistente.apiservice.models.Exam;
import com.asistente.apiservice.models.Planning;
import com.asistente.apiservice.models.Goal;
import com.asistente.apiservice.models.Mode;
import com.asistente.apiservice.repository.ExamRepository;
import com.asistente.apiservice.repository.GoalRepository;
import com.asistente.apiservice.repository.PlanningRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanningService {

    @Autowired
    private PlanningRepository planningRepository;
    @Autowired
    private ExamRepository examRepository; 
    @Autowired
    private GoalRepository goalRepository; 

     /**GET : Retorna el conjunto total de planificaciones registrados en la base de datos */
     public List<Planning> listarPlanificaciones() {
       return planningRepository.findAll();
       
     }
    
     /**GET : Retorna el conjunto total de planificaciones registrados en la base de datos */
     public List<Planning> getPlanningsByExamId(Integer idExam) {
        Exam exam = examRepository.findById(idExam).get();
        List<Planning> allPlannings = this.listarPlanificaciones();
        List<Planning> planningsAsociadas = new ArrayList<Planning>();
        for (Planning planning: allPlannings){
            if (planning.getExam().equals(exam))
                planningsAsociadas.add(planning);

        }
        return planningsAsociadas;
    }
 
     /**POST : Crear y guardar una nueva planificación a partir de los datos del final y el modo indicado */
     public Planning crearPlanificacion(int idExam, Mode modo) {
        //Creo la planificación
        Planning newPlanning = new Planning();
        //Recupero el final
        Exam finalTest = examRepository.findById(idExam).get();
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
    private long getCantDiasReales(Exam finalTest){
         Date fechaInicioEstudio = finalTest.getInicioEstudioDate();
         Date fechaFinal = finalTest.getFinalTestDate();
         long diferencia = fechaFinal.getTime() - fechaInicioEstudio.getTime();
         long days = diferencia / (24*60*60*1000);
        return days - 1;
    }
    //METODO: Obtiene la cantidad de días NECESARIOS para estudiar todos los temas -> tiene en cuenta el modo
    private int getCantDiasPorTemaNecesarios(Mode modo, int cantTemas){
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