package com.asistente.apiservice.repository;

import com.asistente.apiservice.models.Exam;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Integer> {

    
}