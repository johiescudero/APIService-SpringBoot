package com.asistente.apiservice.repository;

import com.asistente.apiservice.models.SubGoal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<SubGoal, Integer> {
    
}