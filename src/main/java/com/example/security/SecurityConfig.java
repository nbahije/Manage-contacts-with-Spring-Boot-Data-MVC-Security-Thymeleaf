package com.example.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	DataSource dataSource;
	
	public SecurityConfig() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		//noop (Not recommended): No password encoder
		/*auth.inMemoryAuthentication().withUser("user").password("{noop}admin").roles("Admin");*/
		
		/**
		 * InMemoryAuthentification by BCRYPT
		 */
		/*BCryptPasswordEncoder bCryptPasswordEncoder = getBCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("user"));
		auth.inMemoryAuthentication().passwordEncoder(bCryptPasswordEncoder);
		auth.inMemoryAuthentication().withUser("admin").password(bCryptPasswordEncoder.encode("admin")).roles("admin","user");
		auth.inMemoryAuthentication().withUser("user").password(bCryptPasswordEncoder.encode("user")).roles("user");
		*/
		
		/**
		 * JDBC Authentification
		 */
		auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select username as connectedUser, password as password, active from user where username = ?")
			.authoritiesByUsernameQuery("select username as connectedUser, role as role from user_role where username = ?")
			.rolePrefix("ROLE_")
			.passwordEncoder(getBCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/admin/*").hasRole("admin");
		http.authorizeRequests().antMatchers("/user/*").hasRole("user");
		http.exceptionHandling().accessDeniedPage("/403");
	}
	
	@Bean
	BCryptPasswordEncoder getBCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
