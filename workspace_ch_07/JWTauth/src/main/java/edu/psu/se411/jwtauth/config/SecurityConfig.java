package edu.psu.se411.jwtauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import edu.psu.se411.jwtauth.service.JwtFilter;
import edu.psu.se411.jwtauth.service.MyUserDetailsService;

@Configuration // tell Spring this is a configuration class (Spring will scan this class for
				// beans)
@EnableWebSecurity // replaces the default filter chain by the one configured here (Spring will
					// scan this class for beans)
public class SecurityConfig {

    @Autowired
    private MyUserDetailsService userDetailsService;
	
    @Autowired
	private JwtFilter jwtFilter;
    
    @Bean 
    public PasswordEncoder encoder() {
    	return new BCryptPasswordEncoder(12);
    }
    
    
	@Bean
	public AuthenticationProvider authenticationProvider(PasswordEncoder encoder) {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(encoder);
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}

	@Bean // Spring will scan this method for beans
	public SecurityFilterChain securityFilterChain(HttpSecurity httpsec) throws Exception {
		return httpsec.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request
														.requestMatchers("register", "login").permitAll()
														.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(jwtFilter,  UsernamePasswordAuthenticationFilter.class)
				.build();
	}

	// Get a reference on the Authentication Manager that uses the Authentication Provider
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
}
