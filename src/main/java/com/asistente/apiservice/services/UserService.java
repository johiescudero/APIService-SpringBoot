package com.asistente.apiservice.services;

// import java.util.ArrayList;
import java.util.List;

import com.asistente.apiservice.models.Users;
import com.asistente.apiservice.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
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
    
    /**GET : Retorna el conjunto total de usuarios registrados en la base de datos */
    public List<Users> listarUsers() {
      return userRepository.findAll();
      
    }
    /**POST : Añadir nuevo usuario */
    // public ResponseEntity<Users> addUser(Users newUser) {
    //     String password = newUser.getPassword();
    //     newUser.setPassword(encoder.encode(password));
    //     Users createdUser = userRepository.save(newUser);
    //     if (createdUser !=null)
    //         return new ResponseEntity<Users>(createdUser,HttpStatus.OK);
    //     else
    //         return new ResponseEntity<Users>(createdUser,HttpStatus.UNAUTHORIZED);
    // }
    /**PUT : Actualizar un usuario */
    // public ResponseEntity<Users> updateUser(int id, Users updUser){
    //    updUser.setId(id);
    // //    return addUser(updUser);
  
    // }

    /**DELETE : Eliminar un usuario con el id */
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
    
}