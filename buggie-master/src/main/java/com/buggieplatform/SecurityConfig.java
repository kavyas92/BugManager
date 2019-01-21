package com.buggieplatform;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.buggieplatform.entity.User;
import com.buggieplatform.repository.UserRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(username -> {
			User user = userRepository.findOne(username);
			if (user != null) {
				return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
						true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
			} else {
				throw new UsernameNotFoundException("Could not find the user '" + username + "'");
			}
		});
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS,"*").permitAll()//allow CORS option calls
	      .antMatchers("/*/**").permitAll().anyRequest().fullyAuthenticated().and().httpBasic().and().csrf().disable();
	}
}