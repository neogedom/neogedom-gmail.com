package com.viniciusgomes.model;


import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

//A falta de getters e setters pode dar essa exceção
// com.fasterxml.jackson.databind.exc.InvalidDefinitionException: No serializer found for class
// ou seja, um problema com o parse do JSON
@Entity
public class Student extends AbstractEntity{
   @NotEmpty(message = "The field name must be provided") // Torna o atributo nome obrigatório
   private String name;
   @NotEmpty(message = "The field email must be provided")
   @Email // Verifica se é um email válidos
   private String email;

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
