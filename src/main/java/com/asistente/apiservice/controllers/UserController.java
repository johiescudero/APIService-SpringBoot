package com.asistente.apiservice.controllers;

import java.util.List;

import com.asistente.apiservice.models.Users;
import com.asistente.apiservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/users")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    /**GET : Retorna el conjunto total de usuarios registrados en la base de datos */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Users> listarUsers(){
      return userRepository.findAll();
      
    }
    /**POST : Añadir nuevo usuario */
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestBody Users newUser) {
        userRepository.save(newUser);
        
    }
    /**PUT : Actualizar un usuario */
    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public void updateUser(@RequestBody Users user){
        userRepository.save(user);
    }
    /**DELETE : Eliminar un usuario con el id */
    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable ("id") Integer id){
        userRepository.deleteById(id);
    }
}