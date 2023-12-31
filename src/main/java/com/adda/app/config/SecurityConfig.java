package com.adda.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity

public class SecurityConfig {
	@Autowired
	private BCryptPasswordEncoder passwoerEncoder;
	/**For User Details Services*/
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
   @Autowired
	private SecurityFilter securityfilter;
	
	/**For Authentication.....*/
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception 
	{
		return authConfig.getAuthenticationManager();
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider() 
	{
		DaoAuthenticationProvider provider  =  new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwoerEncoder);
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	
/** For authorization*/	
	@Bean
	public SecurityFilterChain configurePaths(HttpSecurity http) throws Exception  
	{
		 http.csrf().disable()
		.authorizeRequests().antMatchers("/auth/login","/auth/save").permitAll()
		.antMatchers("/admin/cat","/admin/cat/save","/admin/cat/del","/admin/cat/update","/admin/maid/save","/admin/maid/get").hasAuthority("ADMIN")
		.antMatchers("/auth/current-user","/admin/maid/active","/admin/maid/{id}","/rating/save","/rating/{mid}","/review/save","review/{id}").hasAnyAuthority("ADMIN","USER")
		
		.anyRequest().authenticated()
		.and()
		.exceptionHandling()
		.authenticationEntryPoint(authenticationEntryPoint)
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.addFilterBefore(securityfilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
		
	}
}
