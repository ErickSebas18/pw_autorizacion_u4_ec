package com.uce.edu.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurity {
	
	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private AuthEntryPointJWT unauthorizedHandler;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throw Exception{

		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/API/v1/Autorizacion/tokens/obtener/**").permiteAll().anyRequest().authenticated();
		
		http.authenticationProvider(this.authenticationProvider());
		return http.build();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(this.passwordEncoder());
		return authProvider;
	}
	
	@Bean
	public PasswordEndoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) {
		return authConfig.getAuthenticationManager();
	}
}
