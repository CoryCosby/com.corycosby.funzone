package com.corycosby.funzone.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.corycosby.funzone.service.UserService;

@Configuration // Defines beans and configurations
@EnableWebSecurity // Adds WebSecurityConfigurationAdapter 
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	// Injects a UserService object into the class
	@Autowired
	private UserService userService;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // Returns a new instance of BCryptPasswordEncoder
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        // Creates a new DaoAuthenticationProvider instance and sets its properties
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configures the authentication provider used by the application
        auth.authenticationProvider(authenticationProvider());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    // Configures the security settings for the application's HTTP requests
	    http.authorizeRequests()
	        .antMatchers(
	            "/registration**",
	            "/js/**",
	            "/css/**",
	            "/img/**").permitAll()
	        .antMatchers("/user/myinfo").hasAnyRole("USER", "ADMIN") 
	        .anyRequest().authenticated()
	        .and()
	        .formLogin()
	        .loginPage("/login")
	        .permitAll()
	        .and()
	        .logout()
	        .invalidateHttpSession(true)
	        .clearAuthentication(true)
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        .logoutSuccessUrl("/login?logout")
	        .permitAll();
	}


}

