package com.astutemohit.KanbanBoard.Configuration;

import com.astutemohit.KanbanBoard.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                    .requestMatchers("/task").hasAnyAuthority("USER", "MANAGER", "SUBADMIN", "ADMIN")
                    .requestMatchers("/panel").hasAnyAuthority("ADMIN", "SUBADMIN","MANAGER")
                    .requestMatchers("/panel/user").hasAnyAuthority("USER","MANAGER","SUBADMIN","ADMIN")
                    .requestMatchers("/panel/manager").hasAnyAuthority("MANAGER","SUBADMIN","ADMIN")
                    .requestMatchers("/panel/subadmin").hasAnyAuthority("SUBADMIN","ADMIN")
                    .requestMatchers("/panel/admin").hasAnyAuthority("ADMIN")
                    .requestMatchers("/taskinfo/edit/**").hasAnyAuthority("ADMIN", "SUBADMIN")
                    .requestMatchers("/delete/**").hasAuthority("ADMIN")
                    .anyRequest().authenticated()
                    .and())
                    .formLogin().permitAll()
            .and()
            .logout().permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/403");
        return http.build();
    }
}