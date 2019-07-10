package com.project.donation.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    // Create 2 users for demo
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("user")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("USER", "ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //HTTP Basic authentication
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/createUser").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/updateUser/**").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/deleteUser/**").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/projects").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/createProject").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/updateProject/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/deleteProject/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable()
                .logout()
                .permitAll();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
}
