package com.viniciusgomes.javaclient;

import com.viniciusgomes.model.PageableResponse;
import com.viniciusgomes.model.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class JavaSpringClientTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:8080/v1/protected/students")
                .basicAuthentication("toyo", "senha")
                .build();

        Student student = restTemplate.getForObject("/{id}", Student.class, 1);// devolve a resposta encapsulada em um objeto Java
        ResponseEntity<Student> entity = restTemplate.getForEntity("/{id}", Student.class, 1);// devolve a resposta encapsulada em um HttpEntity que possui informações a mais como cabeçalho, por ex.
        System.out.println(student);
        System.out.println(entity.getBody());
        //Obtendo uma lista de estudantes
//        Student[] students = restTemplate.getForObject("/", Student[].class, 1);
//        System.out.println(Arrays.toString(students));
//        // Retornando um ResponseEntity que encapsula uma lista de estudantes
//        ResponseEntity<List<Student>> exchange = restTemplate.exchange("/", HttpMethod.GET, null,
//                new ParameterizedTypeReference<List<Student>>() {
//                });
//        System.out.println(exchange.getBody());

        // Obtendo uma lista de estudantes paginada
        ResponseEntity<PageableResponse<Student>> exchange = restTemplate.exchange("/", HttpMethod.GET, null,
                new ParameterizedTypeReference<PageableResponse<Student>>() {
                });
        System.out.println(exchange);

    }
}
