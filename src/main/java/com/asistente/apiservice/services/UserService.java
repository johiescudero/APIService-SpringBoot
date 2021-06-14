package com.asistente.apiservice.services;
import java.util.List;

import com.asistente.apiservice.models.Users;
import com.asistente.apiservice.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UsersRepository userRepository;
    
    /**POST: Loguear usuario */
    public Users login(Users userLoggued){
        Users findIt = userRepository.findByEmail(userLoggued.getEmail());
        if (findIt.getPassword().equals(userLoggued.getPassword()))
            return findIt;
        else
            return null;
    }

    /**GET : Retorna el conjunto total de usuarios registrados en la base de datos */
    public Users getUserById(Integer id) {
      return userRepository.findById(id).get();
      
    }

     /**GET : Retorna el usuario con ID igual al parametro especificado */
     public List<Users> listarUsers() {
        return userRepository.findAll();
      }
    
    /**POST : Añadir nuevo usuario */
    public Users addUser(Users newUser) {
        // String password = newUser.getPassword();
        // newUser.setPassword(encoder.encode(password));
        return userRepository.save(newUser);
    }

    //**PUT : Actualizar un usuario */
    public Users updateUser(int id, Users updUser){
         updUser.setId(id);
        return addUser(updUser);
    }
  
    /**DELETE : Eliminar un usuario con el id */
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }

}