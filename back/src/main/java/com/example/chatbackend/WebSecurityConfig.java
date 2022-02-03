package com.example.chatbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .permitAll()
            .and()
            .logout()
            .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("younes").password("{noop}younes").roles("USER");
        auth.inMemoryAuthentication().withUser("you").password("{noop}nes").roles("USER");
        auth.inMemoryAuthentication().withUser("abdelwahab").password("{noop}abdelwahab").roles("USER");
        auth.inMemoryAuthentication().withUser("abdel").password("{noop}wahab").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("USER","ADMIN");
    }
}
