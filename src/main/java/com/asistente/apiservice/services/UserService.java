package com.asistente.apiservice.services;

import java.util.ArrayList;
import java.util.List;

import com.asistente.apiservice.models.Users;
import com.asistente.apiservice.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;
    //Indica a spring de donde se van a sacar los datos del usuario.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Users usuario = userRepository.findByNombre(username);
        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority("ADMIN"));
        UserDetails newUserDetails = new User(usuario.getNombre(),usuario.getClave(),roles);
        return newUserDetails;
    }
    
}