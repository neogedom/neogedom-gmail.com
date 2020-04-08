package com.viniciusgomes.handler;

import org.apache.commons.io.IOUtils;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;

@ControllerAdvice // @ControllerAdvice porque é uma configuração global que estamos a fazer
public class RestResponseExceptionHandler extends DefaultResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        System.out.println("Inside hasError");
        return super.hasError(response);
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        System.out.println("Inside handleError " + response.getStatusCode());
        System.out.println("Inside handleError " + IOUtils.toString(response.getBody(), "UTF-8")); //IOUtils.toString do commons.io para converter InputStream em String
//        super.handleError(response); // comentado para remover o stack de exceções
    }
}
