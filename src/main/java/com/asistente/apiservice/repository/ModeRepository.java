package com.asistente.apiservice.repository;

import java.util.List;

import com.asistente.apiservice.models.Mode;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeRepository extends JpaRepository<Mode,Integer>{

   
   List<Mode> findByModo(String modo);

}
    