package com.bootcamp.eurekaserver;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    /*Securización Servidor Eureka*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); //desactivacion de proteccion entre dominios
        http.authorizeHttpRequests().anyRequest().authenticated().and().httpBasic(); //politicas de autenticación
    }

    @Override
    public void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.
                inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}admin")
                .roles("ADMIN");
    }
}
