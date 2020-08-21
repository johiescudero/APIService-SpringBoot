package com.asistente.apiservice.repository;

import com.asistente.apiservice.models.FinalExam;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FinalExamRepository extends JpaRepository<FinalExam, Integer> {
    
}