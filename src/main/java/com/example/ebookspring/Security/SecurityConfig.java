package com.example.ebookspring.Security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailService userDetailService;


    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/","/login/**","/books", "/books/search", "/register/**", "/css/**", "/js/**").permitAll()
                .requestMatchers("/books/{id}").hasAnyAuthority("USER", "ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/books/{id}/delete")).hasAnyAuthority("ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/books/{id}/edit")).hasAnyAuthority("ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/users/**")).hasAnyAuthority("ADMIN")
                .and()
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/books", true) // Redirect to /books on successful login
                        .failureUrl("/login") // Redirect to /login on login failure
                        .loginProcessingUrl("/login")
                        .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll()
                );
        return http.build();
    }

    public void configure(AuthenticationManagerBuilder builder) throws Exception{
        builder.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }
}
