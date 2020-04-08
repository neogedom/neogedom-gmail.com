package com.viniciusgomes.javaclient;

import com.viniciusgomes.model.PageableResponse;
import com.viniciusgomes.model.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class JavaClientDAO {

    private RestTemplate restTemplate = new RestTemplateBuilder()
            .rootUri("http://localhost:8080/v1/protected/students")
            .basicAuthentication("toyo", "senha")
            .build();

    private RestTemplate restTemplateAdmin = new RestTemplateBuilder()
            .rootUri("http://localhost:8080/v1/admin/students")
            .basicAuthentication("toyo", "senha")
            .build();

    public Student findById(long id) {
       return restTemplate.getForObject("/{id}", Student.class, 1);// devolve a resposta encapsulada em um objeto Java
//        ResponseEntity<Student> entity = restTemplate.getForEntity("/{id}", Student.class, 1);// devolve a resposta encapsulada em um HttpEntity que possui informações a mais como cabeçalho, por ex.
    }

    public List<Student> listAll() {
        ResponseEntity<PageableResponse<Student>> exchange = restTemplate.exchange("/", HttpMethod.GET, null,
                new ParameterizedTypeReference<PageableResponse<Student>>() {
                });

        return exchange.getBody().getContent();

    }

    public Student save(Student student) {
        ResponseEntity<Student> exchangePost = restTemplateAdmin.exchange("/",
                HttpMethod.POST, new HttpEntity<>(student, createJSONHeaders()), Student.class);
        return  exchangePost.getBody();

    }

    private static HttpHeaders createJSONHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
