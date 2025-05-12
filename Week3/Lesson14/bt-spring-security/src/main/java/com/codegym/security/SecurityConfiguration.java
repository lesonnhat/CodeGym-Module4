package com.codegym.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("12345")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("12345")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("/", "/login", "/logout").permitAll() // Cho phép tất cả mọi người
                .requestMatchers("/user").hasRole("USER") // Yêu cầu quyền USER
                .requestMatchers("/admin").hasRole("ADMIN") // Yêu cầu quyền ADMIN
                .requestMatchers("/posts/create").authenticated() // Yêu cầu đăng nhập
                .anyRequest().authenticated() // Các request khác yêu cầu xác thực
                .and()
                .formLogin()
                .loginPage("/login") // Trang đăng nhập tùy chỉnh
                .defaultSuccessUrl("/") // Sau khi đăng nhập thành công, chuyển hướng về trang chủ
                .failureUrl("/login?error=true") // Nếu đăng nhập thất bại, chuyển hướng về trang đăng nhập với tham số error
                .permitAll() // Cho phép tất cả mọi người truy cập trang đăng nhập
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .permitAll()
                .and()
                .csrf().disable(); // Tắt CSRF (chỉ cho mục đích demo, KHÔNG nên tắt trong môi trường production)
    }
}