package com.example.tiviaavaliacao.config;

import org.springframework.boot.autoconfigure.security.reactive.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests(authorizeRequests ->
	                authorizeRequests
	                    .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").authenticated()
	                    .requestMatchers("/h2-console/**").authenticated()
	                    .anyRequest().authenticated()
	            )
	            .httpBasic()
	            .and()
	            .csrf().disable()
	            .headers(headers -> headers.frameOptions().sameOrigin());
	        
	        return http.build();
	    }
}