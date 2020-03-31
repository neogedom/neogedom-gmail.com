package com.viniciusgomes.repository;

import com.viniciusgomes.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StudentRepository extends CrudRepository<Student, Long> // O Long no Generics é o tipo que representa o Id
    //A classe CrudRepository já tem alguns métodos importantes como achar por Id, deletar, etc.
{

    List<Student> findByName (String name);


}
