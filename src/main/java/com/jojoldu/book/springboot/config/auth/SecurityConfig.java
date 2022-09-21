package com.jojoldu.book.springboot.config.auth;


import lombok.RequiredArgsConstructor;
import com.jojoldu.book.springboot.domain.user.Role;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    .authorizeRequests()
                    .antMatchers("/","/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile", "/api/v1/**").permitAll()
                    //.antMatchers("/api/v1/**").hasRole(Role.USER.name()) GUEST,USER 여부 상관없이 접속가능
                    //.anyRequest().authenticated() 메뉴가 새로 생성됨에 따라 로그인 없이도 페이지 접속가능
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                    .userInfoEndpoint()
                    .userService(customOAuth2UserService);
    }
}
