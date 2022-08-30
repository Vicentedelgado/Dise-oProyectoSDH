package com.sdhdata;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sdhdata.util.LoginSuccessMassage;

@SuppressWarnings("deprecation")
@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;
	
	@Autowired
	private LoginSuccessMassage successMessage;
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/spidata_sdh","/css/**","/js/**","/img","/images/**","/datatable/**","/icons/**").permitAll()
		//.antMatchers("dataspi_consulta").hasAnyRole("admin")
		//.antMatchers("dataspi_consulta").hasAnyRole("visitor")
		//.antMatchers("spidata_sdh").hasAnyRole("ADMIN")
		//.anyRequest().authenticated()
		.and()
		.formLogin()
			.successHandler(successMessage)
			.loginPage("/login").permitAll()
		.and()
		.logout().permitAll();
	
	}



	@Autowired
	public void configurerSecurityGlobal(AuthenticationManagerBuilder builder) throws Exception{
		builder.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(passEncoder)
		.usersByUsernameQuery("select username, password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select u.username, r.rol from roles r inner join users u on r.user_id=u.iduser where u.username=?");
	}
	

}
