package com.adda.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecondMachinTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondMachinTestApplication.class, args);
	}
	 @Bean
		public BCryptPasswordEncoder passwordEncoderI() 
		{
			return new BCryptPasswordEncoder();
		}
}
