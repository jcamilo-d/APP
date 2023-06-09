package com.example.APP.Config;

import com.example.APP.Interface.interfaceUser;
import com.example.APP.Model.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.example.APP.Utils.AuthorityName.Administrador;

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
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers( "/registro**",
                                "/js/**",
                                "/css/**",
                                "/libs/**",
                                "/img/**").permitAll()


                ).authorizeHttpRequests((requests)->requests
                        .requestMatchers("/admin/**",
                                "/js/**",
                                "/css/**",
                                "/libs/**",
                                "/img/**").hasAuthority("Administrador")
                        .anyRequest().authenticated()
                )
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout?alert=logout")
                .permitAll();

        return http.build();
    }


}
