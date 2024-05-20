package com.example.webservices_api.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    // Authentication, Authorization, users, roles, crypto
    // Authentication = Är du inloggad
    // Authorization = Vilken roll/behörighet har du, vad har du åtkomst till
    // Crypto = Kryptering av t.ex. lösenord

    // SecurityFilterChain (Böna) = Kedja av filter att ta sig igenom
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        // http.csrf((csrf)-> csrf.disable());          // Disables CSRF
        http
                .authorizeHttpRequests((authorize)->authorize
                        .requestMatchers("/").permitAll()
                        .requestMatchers("/h2-console/**").permitAll()
                        .requestMatchers("/user/products").hasRole("USER")
                        .requestMatchers("/admin/products").hasRole("ADMIN")
                        // .anyRequest() = Övriga endpoints som inte är specificerade av requestMatchers.
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .logout((logout)->logout.logoutSuccessUrl("/"));
        return http.build();

    }
    // UserDetailsService (Böna) = Där skapar man sina användare
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails1 = User.withDefaultPasswordEncoder()
                .username("pelle")
                .password("apa")
                .roles("USER")
                .build();
        UserDetails userDetails2 = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("apa")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }
}
