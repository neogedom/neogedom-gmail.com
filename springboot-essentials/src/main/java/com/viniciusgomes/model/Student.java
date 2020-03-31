package com.viniciusgomes.model;


import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

//A falta de getters e setters pode dar essa exceção
// com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class
// ou seja, um problema com o parse do JSON
@Entity
public class Student extends AbstractEntity{
   private String name;

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
