package co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.config;

import co.edu.unbosque.ARBOLSOLUTIONSBOSQUEFARMA.service.FuncionarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Configuracion {

    private final FuncionarioService funcionarioDetailsService;

    public Configuracion(FuncionarioService funcionarioDetailsService) {
        this.funcionarioDetailsService = funcionarioDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests() 
            .antMatchers("/api/login", "/css/*", "/js/*").permitAll() 
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage("/api/login")
                .defaultSuccessUrl("/api/home", true)
                .permitAll()
            .and()
            .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/api/login?logout")
                .permitAll();
        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(funcionarioDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }
}
