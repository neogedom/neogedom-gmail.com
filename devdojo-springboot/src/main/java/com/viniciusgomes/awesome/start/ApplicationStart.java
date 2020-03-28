package com.viniciusgomes.awesome.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//O próprio SpringBoot se encarrega de startar o web servidor
@EnableAutoConfiguration // importante para que o Spring leia no pom quais configurações adicionar
@ComponentScan(basePackages = "com.viniciusgomes.awesome.endpoint") // aponta para o framework onde estão as classes
// encapsulam os endpoints
public class ApplicationStart {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationStart.class, args);
    }
}
