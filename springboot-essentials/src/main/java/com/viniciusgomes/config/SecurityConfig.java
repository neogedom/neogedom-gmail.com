package com.viniciusgomes.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity //Adicionar a segurança do Spring Security
@EnableGlobalMethodSecurity(prePostEnabled = true) // para o PreAuthorize funcionar
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override //Necessário sobrescrever
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated() // permitir qualquer requisição que seja autorizada
                .and()
                .httpBasic() // método de autenticação Http Basic (a autorização vem no header)
                .and()
                .csrf().disable(); // Só para teste. O CSRF protege ataques a serviços que possuem a sessão aberta
    }

    @Autowired // O AutoWired permite que o String realize a autenticação antes de se acessar o endpoint
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("vinicius")
                .password(encoder.encode("senha"))
                .roles("USER")//Permissões do usuário vinicius
                .and()
                .withUser("admin")
                .password(encoder.encode("senha"))
                .roles("USER","ADMIN");
    }
}
