//package com.my_training.pma.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import jakarta.activation.DataSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration {
//	
//	//@Autowired
//	//DataSource dataSource;
//	
//	// in memorie authentication 
//	  @Bean
//	    public UserDetailsService userDetailsService() {
//	        UserDetails admin = User.withDefaultPasswordEncoder()
//	                .username("admin")
//	                .password("Pass1")
//	                .roles("ADMIN")
//	                .build();
//
//	        UserDetails laura = User.withDefaultPasswordEncoder()
//	                .username("laura")
//	                .password("password1")
//	                .roles("USER")
//	                .build();
//
//	        UserDetails user = User.withDefaultPasswordEncoder()
//	                .username("user")
//	                .password("password1")
//	                .roles("USER")
//	                .build();
//	        
//	       // UserDetails admin = User.jdbc  
//	        
//
//	        return new InMemoryUserDetailsManager(admin, laura, user);
//	    }
//	  
//	
//	//in memory Authorization
//	  @Bean
//	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//	        http
//	            .authorizeRequests(authorizeRequests ->
//	                authorizeRequests
//	                    .requestMatchers("/project/new").hasRole("ADMIN")
//	                    .requestMatchers("/employee/new").hasRole("ADMIN")
//	                    .requestMatchers("/").authenticated()
//	            )
//	            .formLogin(formLogin -> formLogin
//	                    .loginPage("/login") // Specifica la pagina di login se ne hai una personalizzata
//	                    .permitAll()
//	                );
//	        return http.build();
//	    }
//}
