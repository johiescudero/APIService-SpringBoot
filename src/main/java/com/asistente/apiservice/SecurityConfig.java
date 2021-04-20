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
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


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
      * Cualquier petición que se realiza debe provenir de un usuario autenticado*/
    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.cors();
        http
            .httpBasic().and()
            .authorizeRequests()
            .antMatchers("/").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and()
            .httpBasic();
        http
        .csrf()
        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        }

    
}
