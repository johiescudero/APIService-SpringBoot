package com.asistente.apiservice.controllers;

import java.util.List;
import com.asistente.apiservice.models.Users;
import com.asistente.apiservice.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/users")
public class UserController {
    
    @Autowired
    private UserService userService; 
    
     /**LOGIN: Inicio de sesión */
	 @PostMapping(value = "/login")
	 public Users login(@RequestBody Users userLoggedIn){
       return userService.login(userLoggedIn);
	 }

     /**GET : Retorna el conjunto total de usuarios registrados en la base de datos */
    @GetMapping(value = "/{id}")
    public Users getUserById(@PathVariable ("id") Integer id){
      return userService.getUserById(id);
    }

     /**GET : Retorna el conjunto total de usuarios registrados en la base de datos */
    @GetMapping(value = "/all")
    public List<Users> listarUsers(){
      return userService.listarUsers();
    }

     /**POST : Añadir nuevo usuario */
     @PostMapping(value = "/add")
     public Users addUser(@RequestBody Users newUser) {
        return userService.addUser(newUser);
     }

    /**PUT : Actualizar un usuario */
    @PutMapping(value = "/update/{id}")
    public void updateUser(@PathVariable ("id")Integer id, @RequestBody Users updUser){
        userService.updateUser(id,updUser);
    }

    /**DELETE : Eliminar un usuario con el id */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable ("id") Integer id){
        userService.deleteUser(id);
    }
}