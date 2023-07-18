package com.greatlearning.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfigurationWithJdbc extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
		.withUser(User.withUsername("nikita").password(getPasswordEncoder().encode("nikita")).roles("STORE_OWNER"))
		.withUser(User.withUsername("rohan").password(getPasswordEncoder().encode("rohan")).roles("STORE_CLERK"));
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable().authorizeRequests().anyRequest().permitAll().and().formLogin();
		http.csrf().disable().authorizeRequests()
		.antMatchers("/dmart/viewFinancials","/dmart/makeAnnouncement")
		.hasRole("STORE_OWNER")
		.antMatchers("/dmart/checkInventory","/dmart/viewInventory","/dmart/doCheckout")
		.hasAnyRole("STORE_OWNER","STORE_CLERK").antMatchers("/").permitAll().and().formLogin();
	}
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
	}
	
}
