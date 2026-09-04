package com.rs.retailstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

        // @Bean
        // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
        // Exception {
        // http
        // .authorizeHttpRequests(auth -> auth
        // .anyRequest().authenticated())
        // .formLogin(form -> form
        // .defaultSuccessUrl("/v1/greeting", true));

        // return http.build();
        // }

        // @Bean
        // public UserDetailsService userDetailsService(DataSource dataSource) {
        // UserDetails user = User.builder()
        // .username("retailstoreappv2")
        // .password("$2a$10$r15G8Qmg4atnWxVDRpX/pe9vKfxJXU2eJSQbnWeSrrj.7FSidLeJ6")
        // .roles("USER")
        // .build();

        // UserDetails admin = User.builder()
        // .username("adminv2")
        // .password("$2a$10$WWVXuRiSInEZx/fgY3rVQuHEO5Y6sydJChH4yel0GEZfeFcb5ix6m")
        // .roles("USER", "ADMIN")
        // .build();
        // JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        // users.createUser(user);
        // users.createUser(admin);
        // return users;
        // }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

        @Bean
        public WebSecurityCustomizer webSecurityCustomizer() {
                return web -> web.ignoring().requestMatchers(
                                "/swagger-ui.html",
                                "/swagger-ui/**",
                                "/v3/api-docs",
                                "/v3/api-docs/**",
                                "/webjars/**");
        }

        @Bean
        SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
                httpSecurity
                                .csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(auth -> auth
                                                .requestMatchers("/v1/register").permitAll()
                                                .requestMatchers("/v1/greeting").authenticated()
                                                .anyRequest().authenticated())
                                .formLogin(Customizer.withDefaults())
                                .httpBasic(Customizer.withDefaults());
                return httpSecurity.build();
        }

}
