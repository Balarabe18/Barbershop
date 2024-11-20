package com.Barbershop.Barbershop.Security;

import com.Barbershop.Barbershop.Service.CustomSuccessHandler;
import com.Barbershop.Barbershop.Service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomSuccessHandler customSuccessHandler;

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/assets/**").permitAll()
                        .requestMatchers("/appointment-success", "/user-appointments").hasAuthority("USER")
                        .requestMatchers("/admin-page").hasAuthority("ADMIN")
                        .requestMatchers("/registration", "/admin/registration").permitAll()
                        .requestMatchers("/homepage", "/services", "/about").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login").loginProcessingUrl("/login")
                        .successHandler(customSuccessHandler).permitAll()
                )
                .logout(logout -> logout
                        .invalidateHttpSession(true).clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout").permitAll()
                );

        return http.build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
    }
}
