package com.sajjan.secureapp;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.bytecode.enhance.internal.tracker.NoopCollectionTracker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.NoOp;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	/*
	 * Creating a dummy user authentication with default password encoder
	 * The below code snippet will run but its not recommended.
	 * 
	 * */
	
//	@Bean
//	@Override
//	protected UserDetailsService userDetailsService() {
//		List<UserDetails> users = new ArrayList<>();
//		users.add(User.withDefaultPasswordEncoder().username("sajjan").password("1234").roles("USER").build());
//	
//		return new InMemoryUserDetailsManager(users);
//	}
	
	// Above code is used till 1st commit"
	
	
//	@Autowired
//	private UserDetailsService userDetailService;
//	
//	@Bean
//	public AuthenticationProvider authProvider(){
//		
//		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailService);
////		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); //This line was used during testing phase with no password encoding which is not recomended.
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		
//		return provider;
//	}
	
//	/*
//	 * overridding a method which now deals with new login and logout page. 
//	 * authorizeRequests and anyRequest functions make sure that all the url are authenticated 
//	 * while other properties deals specifically with login page and its respective functions.
//	 * */
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http
//			.csrf().disable()
//			.authorizeRequests().antMatchers("/login").permitAll()
//			.anyRequest().authenticated()
//			.and()
//			.formLogin()
//			.loginPage("/login").permitAll()
//			.and()
//			.logout().invalidateHttpSession(true)
//			.clearAuthentication(true)
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.logoutSuccessUrl("/logout-success").permitAll();
//		
//	}	
//	
	
	// The above code is used till 2nd commit for BCrypt // 
	
	
	/*
	 * 
	 * */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
			.csrf().disable()
			.authorizeRequests().antMatchers("/login").permitAll()
			.anyRequest().authenticated();
		
	}	
	
}
