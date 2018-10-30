package com.globallogic.procamp.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
                    throws Exception {

        auth.inMemoryAuthentication().withUser("user")
                        .password(passwordEncoder()
                        .encode("password"))
                        .roles("USER")
                        .and()
                        .withUser("admin")
                        .password(passwordEncoder().encode("admin"))
                        .roles("ADMIN");
        
         /*
            http://www.springframework.org/security/tags
            
            <div sec:authorize="hasRole('USER')">
            
            <div sec:authorize="isAuthenticated()">
        */
    }

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                        .anyRequest().authenticated()
                        .and().formLogin()
                        .loginPage("/mvc/login").permitAll();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //
    //    protected void configure(HttpSecurity http) throws Exception {
    //        http.authorizeRequests()
    //                        .anyRequest().authenticated()
    //                        .and().httpBasic();
    //    }
    //
    //    @Override
    //    protected void configure(HttpSecurity http) throws Exception {
    //        http
    //                        .authorizeRequests()
    //                        .antMatchers("/", "/mvc/list").permitAll()
    //                        .anyRequest().authenticated()
    //                        .and()
    //                        .formLogin()
    //                        .loginPage("/mvc/login")
    //                        .permitAll()
    //                        .and()
    //                        .logout()
    //                        .permitAll();
    //    }
    //
    //    @Bean
    //    @Override
    //    public UserDetailsService userDetailsService() {
    //        UserDetails user = User.withDefaultPasswordEncoder()
    //                                .username("user")
    //                                .password("password")
    //                                .roles("USER")
    //                                .build();
    //
    //        return new InMemoryUserDetailsManager(user);
    //    }
    //    
    //    @Autowired
    //    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //        auth
    //        .inMemoryAuthentication()
    //        .withUser("user")
    //            .password(passwordEncoder().encode("password"))
    //            .roles("USER")
    //        .and()
    //        .withUser("admin")
    //            .password(passwordEncoder().encode("admin"))
    //            .roles("ADMIN");
    //    }
    //
    
}
