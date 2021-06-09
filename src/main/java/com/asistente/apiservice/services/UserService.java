package com.asistente.apiservice.services;

// import java.util.ArrayList;
import java.util.List;

import com.asistente.apiservice.models.Users;
import com.asistente.apiservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService  
//implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;
    // @Autowired
	// private BCryptPasswordEncoder encoder;
    
    //Indica a spring de donde se van a sacar los datos del usuario.
    // @Override
    // public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
    //     Users usuario = userRepository.findByEmail(email);
        
    //     List<GrantedAuthority> roles = new ArrayList<>();
    //     roles.add(new SimpleGrantedAuthority("ADMIN"));
        
    //     UserDetails newUserDetails = new User(usuario.getName(), usuario.getPassword(), roles);
        
    //     return newUserDetails;
    // }
    
    /**POST: Loguear usuario */
    public Users login(Users userLoggued){
               
        return userRepository.findByEmail(userLoggued.getEmail());
    }


    /**GET : Retorna el conjunto total de usuarios registrados en la base de datos */
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