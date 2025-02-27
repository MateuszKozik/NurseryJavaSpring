
package com.kozik.nursery.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecuityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private DataSource dataSource;
    
     @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder()).rolePrefix("ROLE_")
                .dataSource(dataSource)
                .usersByUsernameQuery("select email as principal, password as credentials, enabled from users where email=?")
                .authoritiesByUsernameQuery("select user_email as principal, role_name as role from users_roles where user_email = ? ");
    }

    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/register", "/", "/home", "/login", "/css/**", "/js/**","/img/**").permitAll()
                .antMatchers("/profile").hasAnyRole("user,admin,pracownik")
                .antMatchers("/address/**", "/child/**", "/employee/**", "/fee/**","/group/**","/item/**","/parent/**", "/record/**", "/room/**", "/user/**").hasAnyRole("admin")
                .antMatchers("/customer/**").hasAnyRole("user")
                .antMatchers("/staff/**").hasAnyRole("pracownik")
                .and().formLogin().loginPage("/login").permitAll()
                .defaultSuccessUrl("/").and().logout().logoutSuccessUrl("/login");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
