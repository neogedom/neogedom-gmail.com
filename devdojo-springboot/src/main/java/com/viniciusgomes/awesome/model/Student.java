package com.viniciusgomes.awesome.model;


//A falta de getters e setters pode dar essa exceção
// com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class
// ou seja, um problema com o parse do JSON
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
