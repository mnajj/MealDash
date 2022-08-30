package com.mealdash.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	private final DataSource securityDataSource;

	public SecurityConfiguration(DataSource securityDataSource) {
		this.securityDataSource = securityDataSource;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
						.anyRequest().authenticated()
						.and()
						.formLogin()
						.permitAll()
						.and()
						.logout()
						.permitAll()
						.and()
						.exceptionHandling()
						.accessDeniedPage("/access-denied");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}
}
