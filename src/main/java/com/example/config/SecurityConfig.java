package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author saito
 *
 */
@Configuration
public class SecurityConfig {


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

		httpSecurity.authorizeRequests()

		//Oauth2.0ログイン認証情報
		.mvcMatchers("/").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.oauth2Login();

		return 	httpSecurity.build();
	}
}
