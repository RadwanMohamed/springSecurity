package com.coder.springsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/account").authenticated()
                .antMatchers("/myBalance").authenticated()
                .antMatchers("/myCards").authenticated()
                .antMatchers("/myLoans").authenticated()
                .antMatchers("/myNotice").permitAll()
                .antMatchers("/myContact").permitAll()
                .and().formLogin().and().httpBasic();
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws  Exception{
        auth.inMemoryAuthentication().withUser("admin").password("123456").authorities("admin")
                .and().withUser("user").password("123456").authorities("read").and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
