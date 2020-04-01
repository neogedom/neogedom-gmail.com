package com.viniciusgomes.repository;

import com.viniciusgomes.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface StudentRepository extends CrudRepository<Student, Long> // O Long no Generics é o tipo que representa o Id
    //A classe CrudRepository já tem alguns métodos importantes como achar por Id, deletar, etc.
{

    List<Student> findByName (String name); // Pega pelo nome exatamente como o nome está

    List<Student> findByNameIgnoreCaseContaining(String name); // Pela pelo nome que contém a substring passada


//    No caso do Sping existe as palavras reservadas / especiais (em ingles) que através delas que é construida a query.
//
//    Exemplo:
//
//    And                          --> (findBy) Lastname (And)  Firstname
//    Or                             --> (findBy) Lastname (Or)  Firstname
//    Is,Equals                 --> (findBy) Firstname, (findBy) FirstnameIs, (findBy) Firstname (Equals)
//    Between                  --> (findBy) (StartDateBetween)
//    LessThan                 --> (findBy) (AgeLessThan )
//    LessThanEqual      --> (findBy) (AgeLessThanEqual)
//    GreaterThan           --> (findBy) (AgeGreaterThan)
//    GreaterThanEqual --> (findBy) (AgeGreaterThanEqual)
//    After                         --> (findBy) (StartDateAfter)
//    Before                     --> (findBy) (StartDateBefore)
//    IsNull                       --> (findBy) (AgeIsNull)
//    IsNotNull,NotNull --> (findBy) (Age(Is)NotNull)
//    Like                          --> (findBy) Firstname(Like)
//    NotLike                   --> (findBy) Firstname(NotLike)
//    StartingWith          --> (findBy) Firstname(StartingWith)
//    EndingWith             --> (findBy) Firstname(EndingWith)
//    Containing             --> (findBy) Firstname(Containing)
//    OrderBy                   --> (findBy) (AgeOrderBy)Lastname(Desc)
//    Not                          --> (findBy) Lastname(Not)
//    In                              --> (findBy) (AgeIn(Collection<Age> ages) )
//    NotIn                       --> (findBy) (AgeNotIn(Collection<Age> ages) )
//    True                         --> (findBy) (ActiveTrue())
//    False                       --> (findBy) (ActiveFalse())
//    IgnoreCase            --> (findBy) Firstname(IgnoreCase)


}
