package com.project.security.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // spring will know that for config it has to go here
@EnableWebSecurity  // says not go in default go in this order i said
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.csrf(customizer -> customizer.disable())
	.authorizeHttpRequests(request -> request.anyRequest().authenticated())
//	//	http.formLogin(Customizer.withDefaults());
.httpBasic(Customizer.withDefaults())
.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

		return http.build();
	}
	
	
//	@Bean
//	public  UserDetailsService userDetailsService() {
//		
//		UserDetails userDetails= User.withDefaultPasswordEncoder().
//				username("priyaa").password("priyas")
//				.roles("USER")
//				.build();
//				
//		return  new InMemoryUserDetailsManager(userDetails);
//	}
	
}
