package com.asistente.apiservice.repository;

import java.util.List;

import com.asistente.apiservice.models.Exam;
import com.asistente.apiservice.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Integer> {


    List<Exam> findByUsuario(Users user);

    
}