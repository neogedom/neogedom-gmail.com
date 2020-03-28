package com.viniciusgomes.awesome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

////O próprio SpringBoot se encarrega de startar o web servidor
//@EnableAutoConfiguration // importante para que o Spring leia no pom quais configurações adicionar
//// @ComponentScan(basePackages = "com.viniciusgomes.awesome.endpoint") // aponta para o framework onde estão as classes
//// Se esta classe estiver na raiz do projeto, não precisamos definir os basePackages
//@ComponentScan
//@Configuration // faz a configuração com as classes que definirmos como configuração

// As três annotations acima podem ser substituidas por
@SpringBootApplication
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
