package com.example.Bookstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/css/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.defaultSuccessUrl("/booklist", true)
		.permitAll()
		.and()
		.logout()
		.permitAll();		
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
		
		List<UserDetails> users = new ArrayList<UserDetails>();
		
		users.add(user);
		
		user = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("password")
				.roles("USER", "ADMIN")
				.build();
				
				users.add(user);
				
		return new InMemoryUserDetailsManager(users);
	}

}
