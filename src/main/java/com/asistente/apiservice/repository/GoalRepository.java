package com.asistente.apiservice.repository;

import java.util.List;
import com.asistente.apiservice.models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal,Integer> {


    //Select * FROM GOALS WHERE idFinal = id
    //Utilizado para a través de la configuración de Spring security obtener un usuario
    List<Goal> findByIdFinal(int id);
}