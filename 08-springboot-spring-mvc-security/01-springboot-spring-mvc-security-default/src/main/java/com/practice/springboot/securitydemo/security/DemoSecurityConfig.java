package com.practice.springboot.securitydemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails Yashmi= User.builder()
                .username("Yashmi")
                .password("{noop}y123")
                .roles("EMPLOYEE").build();
        UserDetails Thiru= User.builder()
                .username("Thiru")
                .password("{noop}th123")
                .roles("EMPLOYEE","MANAGER").build();
        UserDetails Gow= User.builder()
                .username("Gow")
                .password("{noop}g123")
                .roles("EMPLOYEE","MANAGER","ADMIN").build();

        return new InMemoryUserDetailsManager(Yashmi,Thiru,Gow);

    }

     */


    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery("Select user_id,pw,active from members where user_id=?");

        //define query to retrieve authorities by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id=?");


        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws  Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/leaders/**").hasRole("MANAGER")
                        .requestMatchers("/systems/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                        .formLogin (form ->
                                form.loginPage("/showMyLoginPage")
                                        .loginProcessingUrl("/authenticateTheUser")
                                        .permitAll()
                        )
                .logout(logout->logout.permitAll()
                        )
                .exceptionHandling(configurer->
                        configurer
                                .accessDeniedPage("/access-denied")
                );
        return http.build();
    }
}
