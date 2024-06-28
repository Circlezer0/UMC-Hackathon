package com.circlezero.hackathon_cake.security;

import com.circlezero.hackathon_cake.domain.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;
    private final CustomUserDetailsService customUserDetailsService;
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(customUserDetailsService);
        provider.setPasswordEncoder(bCryptPasswordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(CsrfConfigurer::disable)
                .cors(Customizer.withDefaults());

        httpSecurity.authorizeHttpRequests(auhz -> auhz
                .requestMatchers("/", "/css/**", "/images/**", "/js**").permitAll()
                .requestMatchers("/admin/**").hasRole(Role.ADMIN.name())
                .requestMatchers("/loginForm/**", "/signinForm/**").anonymous()
                .anyRequest().permitAll()
        );

        httpSecurity.formLogin(form -> form
                .loginPage("/loginForm")
                .usernameParameter("userId")
                .passwordParameter("password")
                .loginProcessingUrl("/loginForm/process")
                .defaultSuccessUrl("/")
                .successHandler(customAuthenticationSuccessHandler)
                .failureHandler(customAuthenticationFailureHandler)
        );

        httpSecurity
                .oauth2Login(oauth -> oauth
                        .loginPage("/loginForm")
                        .userInfoEndpoint(userInfoEndpointConfig -> userInfoEndpointConfig
                                .userService(customOAuth2UserService)
                        )
                        .defaultSuccessUrl("/", true)
                );

        httpSecurity
                .logout(logoutConfig -> logoutConfig
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/")
                );

        return httpSecurity.build();
    }
}