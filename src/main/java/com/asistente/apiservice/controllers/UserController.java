package com.asistente.apiservice.controllers;

import java.util.List;

import com.asistente.apiservice.models.Users;
import com.asistente.apiservice.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/users")
public class UserController {
    
    @Autowired
    private UserService userService; 
    @Autowired
	private BCryptPasswordEncoder encoder;
    
    /**GET : Retorna el conjunto total de usuarios registrados en la base de datos */
    @GetMapping(value = "/all")
    public List<Users> listarUsers(){
      return userService.listarUsers();
      
    }
    /**POST : Añadir nuevo usuario */
    @PostMapping(value = "/add")
    public ResponseEntity<Users> addUser(@RequestBody Users newUser) {
        String password = newUser.getPassword();
        newUser.setPassword(encoder.encode(password));
        Users createdUser = userService.addUser(newUser);
        if (createdUser !=null)
            return new ResponseEntity<Users>(createdUser,HttpStatus.OK);
        else
            return new ResponseEntity<Users>(createdUser,HttpStatus.INTERNAL_SERVER_ERROR);
    }


    /**PUT : Actualizar un usuario */
    @PutMapping(value = "/update/{id}")
    public void updateUser(@RequestBody Users updUser){
        userService.updateUser(updUser);
    }
    /**DELETE : Eliminar un usuario con el id */
    @DeleteMapping(value = "/delete/{id}")
    public void deleteUser(@PathVariable ("id") Integer id){
        userService.deleteUser(id);
    }
}