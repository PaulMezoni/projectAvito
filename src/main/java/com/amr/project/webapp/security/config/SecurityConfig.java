package com.amr.project.webapp.security.config;

import com.amr.project.webapp.handler.SuccessHandler;
import com.amr.project.webapp.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    private final SuccessHandler successHandler;

    public SecurityConfig(UserDetailsServiceImpl userDetailsServiceImpl, SuccessHandler successHandler) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.successHandler = successHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .formLogin().loginPage("/homepage").permitAll()
                .loginProcessingUrl("/index")
                .successHandler(successHandler)
                .and()
                .rememberMe().userDetailsService(userDetailsServiceImpl)
                .key("$2a$12$77RCxpN39Xd9K4y1jsSGSObeEZ/glP9YkwzRFCiMSJxqrbcXz9mS6")
                .and()
                .authorizeRequests()
                .antMatchers("/", "/allShops", "/registration", "/registrationConfirm").permitAll()
                .antMatchers("/js/**","/css/**").permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
                .antMatchers("/moderator/**").hasAnyAuthority("MODERATOR", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .and()
                .logout().logoutSuccessUrl("/").permitAll()
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID", "remember-me");
    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsServiceImpl);
        daoAuthenticationProvider.setPasswordEncoder(encoder());
        return daoAuthenticationProvider;
    }

    @Autowired
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }
}