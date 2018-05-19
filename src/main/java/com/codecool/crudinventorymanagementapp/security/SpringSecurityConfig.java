package com.codecool.crudinventorymanagementapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Autowired
    SuccessHandler successHandler;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/employee/**").hasAnyRole("ADMIN")
                .antMatchers("/inventory/**").hasAnyRole("EMPLOYEE")
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .successHandler(successHandler);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        web.ignoring().antMatchers("/webjars/**");
        web.ignoring().antMatchers("/css/**", "/fonts/**", "/libs/**");
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication) throws Exception {

        authentication.inMemoryAuthentication()
                .withUser("user").password("user").roles("EMPLOYEE")
                .and()
                .withUser("admin").password("admin").roles("ADMIN");
    }
}