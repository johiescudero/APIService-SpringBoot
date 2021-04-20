package com.asistente.apiservice.controllers;

import java.util.List;
import com.asistente.apiservice.models.Users;
import com.asistente.apiservice.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private UserService userService; 
    
     /**LOGIN: Inicio de sesión */
	 @GetMapping(value = "/login")
	 public String login(Users user){
                  
         return "Estas autenticado";
	 }

     /**GET : Retorna el conjunto total de usuarios registrados en la base de datos */
    @GetMapping(value = "/users/all")
    public List<Users> listarUsers(){
      return userService.listarUsers();
    }

     /**POST : Añadir nuevo usuario */
    @PostMapping(value = "/users/add")
    public ResponseEntity<Users> addUser(@RequestBody Users newUser) {
        return userService.addUser(newUser);
    }

    /**PUT : Actualizar un usuario */
    @PutMapping(value = "/users/update/{id}")
    public void updateUser(@PathVariable ("id")Integer id, @RequestBody Users updUser){
        userService.updateUser(id,updUser);
    }
    /**DELETE : Eliminar un usuario con el id */
    @DeleteMapping(value = "/users/delete/{id}")
    public void deleteUser(@PathVariable ("id") Integer id){
        userService.deleteUser(id);
    }
}