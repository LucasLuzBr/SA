package br.com.sa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.sa.security.SecurityDetailsService;

@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private SecurityDetailsService securityDetailsService;

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http
            .authorizeRequests()
            .antMatchers("/").permitAll()

            .antMatchers("/bootstrap-4.5.2/**").permitAll()
            .antMatchers("/css/**").permitAll()
            .antMatchers("/js/**").permitAll()
            .antMatchers("/fontawesome-5.14.0/**").permitAll()
            .antMatchers("/js/**").permitAll()
            .antMatchers("/novoCadastro").permitAll()
            .and()

            .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()

            .rememberMe();
    
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder builder)throws Exception{
        builder
            .userDetailsService(securityDetailsService)
            .passwordEncoder(new BCryptPasswordEncoder());
    }

    public static void main(String[]args){
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }
}
