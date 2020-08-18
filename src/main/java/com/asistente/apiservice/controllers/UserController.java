package com.asistente.apiservice.controllers;

import java.util.List;

import com.asistente.apiservice.models.Users;
import com.asistente.apiservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    /**GET : Retorna el conjunto total de usuarios registrados en la base de datos */
    @GetMapping
    public List<Users> listar(){
      return userRepository.findAll();
      
    }
    /**POST : Añadir nuevo usuario */
    @PostMapping
    public void insertar(@RequestBody Users newUser) {
        userRepository.save(newUser);
        
    }
    /**PUT : Actualizar un usuario */
    @PutMapping
    public void modificar(@RequestBody Users user){
        userRepository.save(user);
    }
    /**DELETE : Eliminar un usuario con el id */
    @DeleteMapping(value = "/{id}")
    public void eliminar(@PathVariable ("id") Integer id){
        userRepository.deleteById(id);
    }
}