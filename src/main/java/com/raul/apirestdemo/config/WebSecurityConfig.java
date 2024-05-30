package com.sermaluc.apirestdemo.config;

import com.sermaluc.apirestdemo.security.JWTAuthorizationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
        .addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/jwt").permitAll()
        .antMatchers("/swagger-ui.html", "/swagger-ui/**", "/v2/api-docs", "/swagger-resources/**").permitAll()
        .anyRequest()
        .authenticated();
  }
}
