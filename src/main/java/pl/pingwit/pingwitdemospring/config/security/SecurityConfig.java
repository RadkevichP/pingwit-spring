package pl.pingwit.pingwitdemospring.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @author Pavel Radkevich
 * @since 1.08.23
 */
@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService users() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails user = users
                .username("pavel")
                .password("pupa")
                .roles("USER")
                .build();
        UserDetails admin = users
                .username("admin")
                .password("lupa")
                .roles("ADMIN", "USER")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(HttpMethod.GET, "/users/**", "/orders/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/users", "/orders/").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/users/**", "/orders/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/users/**").hasRole("ADMIN")
                        .requestMatchers("/hello/**").hasRole("HELLO")
                        .requestMatchers("/random-joke").permitAll()
                        .anyRequest().authenticated())
                .build();
    }

}
