package psu.edu.ch06.crud02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Keep HTTP Basic authentication enabled (configured via application.properties)
        // Disable CSRF for API endpoints so API clients (Postman, curl) can POST without a CSRF token.
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/v1/**").authenticated()
                .anyRequest().permitAll()
            )
            .httpBasic()
            .and()
            .csrf(csrf -> csrf.ignoringRequestMatchers("/v1/**"));

        return http.build();
    }
}
