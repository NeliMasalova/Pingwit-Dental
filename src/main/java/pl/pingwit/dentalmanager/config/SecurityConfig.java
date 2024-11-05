package pl.pingwit.dentalmanager.config;

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


@Configuration
public class SecurityConfig {
    private static final String ADMIN_ROLE = "ADMIN";
    private static final String USER_ROLE = "USER";

    @Bean
    public UserDetailsService users() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        UserDetails user = users
                .username("Egorka")
                .password("pingwit")
                .roles(USER_ROLE)
                .build();
        UserDetails admin = users
                .username("admin")
                .password("pingwit2024")
                .roles(ADMIN_ROLE, USER_ROLE)
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/patient/**", "/doctor/**",
                                "/treatment/**", "/treatment/{id}", "/appointment", "/appointment/{id}", "/payment").hasRole(USER_ROLE)
                        .requestMatchers(HttpMethod.POST, "/patient","/doctor", "/treatment", "/appointment/with-payment").hasRole(ADMIN_ROLE)
                        .requestMatchers(HttpMethod.PUT, "/patient/**","/doctor/**" ).hasRole(ADMIN_ROLE)
                        .requestMatchers(HttpMethod.DELETE, "/patient/**","/doctor/**","/appointment","/payment/{id}" ).hasRole(ADMIN_ROLE)
                        .anyRequest().authenticated())
                .build();
    }
}