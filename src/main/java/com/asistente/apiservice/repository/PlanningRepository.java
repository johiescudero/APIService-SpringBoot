package com.asistente.apiservice.repository;

import com.asistente.apiservice.models.Planning;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanningRepository extends JpaRepository<Planning,Integer>{
    
}