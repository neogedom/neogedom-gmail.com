package com.viniciusgomes.javaclient;

import com.viniciusgomes.model.PageableResponse;
import com.viniciusgomes.model.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class JavaSpringClientTest {
    public static void main(String[] args) {


        Student studentPost = new Student();
        studentPost.setName("Saitama");
        studentPost.setEmail("john@pencil.com");
        studentPost.setId(3L);
        JavaClientDAO dao = new JavaClientDAO();
//        System.out.println(dao.findById(1));
//        System.out.println(dao.listAll());
//        System.out.println(dao.save(studentPost));
//        dao.update(studentPost);
        dao.delete(3);
    }


}
