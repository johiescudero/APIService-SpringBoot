package com.asistente.apiservice;

import com.asistente.apiservice.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserService userDetailsService;
    @Autowired
    private BCryptPasswordEncoder bCrypt;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    //Configuración de dónde están los usuarios registrados
    @Override
    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        auth
            .userDetailsService(userDetailsService).passwordEncoder(bCrypt);
    }

    /**
     * Cualquier petición que se realiza debe provenir de un usuario autenticado
     //COMENTADO MOMENTANEAMENTE PARA PRUEBAS A TRAVÉS DE POSTMAN
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http
            .authorizeRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }
    */
    /**
     * Se permite cualquier solicitud, es para la prueba de la API REST
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {    
        http
            .csrf().disable()
            .authorizeRequests()
                .anyRequest().permitAll();
        }
}