package com.asistente.apiservice.repository;

import java.util.List;

import com.asistente.apiservice.models.Exam;
import com.asistente.apiservice.models.Planning;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PlanningRepository extends JpaRepository<Planning,Integer>{

    List<Planning> findByExam(Exam idExam);
    
}