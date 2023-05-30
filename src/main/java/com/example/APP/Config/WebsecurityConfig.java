package com.example.APP.Config;

import com.example.APP.Interface.interfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class WebsecurityConfig {
  /*  @Bean
    public UserDetailsService userDetailsService(){
        var user= User.withUsername("user")
                .password("123")
                .roles("user")
                .build();

        return new InMemoryUserDetailsManager(user);
    }*/

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }



}
