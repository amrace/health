package com.example.health.securityConfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private CustomLoginSuccessHandler customLoginSuccessHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	/*     auth.inMemoryAuthentication().withUser("admin")
        .password("{noop}admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("freddy")
        .password("{noop}freddy").roles("SELLER");
		auth.inMemoryAuthentication().withUser("bob")
        .password("{noop}bob").roles("USER");*/

    	
    	
    	
    	auth.jdbcAuthentication().dataSource(dataSource)
        .usersByUsernameQuery("select email,password,enabled from user where email=?")
        .authoritiesByUsernameQuery("select role as role1,role as role2 from user where email=?")
        .dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
    	
    	}
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
        .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/doctor/**").access("hasRole('ROLE_DOCTOR')")
        .antMatchers("/user/**").access("hasRole('ROLE_USER')")
        
        .antMatchers("/signup/**").permitAll()
        .antMatchers("/api/mobile/**","/api1/mobile1/**","/api1/item1/**").permitAll()

                .antMatchers("/resources/**").permitAll()
                .antMatchers("/vendor/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/getAll/**").permitAll()
                .antMatchers("/update/**").permitAll()
                .antMatchers("/report/**").permitAll()
                .antMatchers("/parameter/**").permitAll()
                .antMatchers("/test/**").permitAll()
                .antMatchers("/searchPatient/**").permitAll()
                .antMatchers("/get/**").permitAll()
                .antMatchers("/bp/save/**").permitAll()
                .antMatchers("/bp/**").permitAll()
                .antMatchers("/bp/{id}/**").permitAll()
                .antMatchers("/bp/save/{id}/**").permitAll()
                .antMatchers("/bodyweight/{id}/**").permitAll()
                .antMatchers("/bodyweight/save/**").permitAll()
                .antMatchers("/pulserate/{id}/**").permitAll()
                .antMatchers("/pulserate/save/**").permitAll()
                .antMatchers("/respiratoryrate/{id}/**").permitAll()
                .antMatchers("/respiratoryrate/save/**").permitAll()
                .antMatchers("/spo2/{id}/**").permitAll()
                .antMatchers("/spo2/save/**").permitAll()
                .antMatchers("/temperature/{id}/**").permitAll()
                .antMatchers("/temperature/save/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
       
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .passwordParameter("password")
                .permitAll()
                .successHandler(customLoginSuccessHandler);
    }
    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
