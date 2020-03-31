package com.viniciusgomes.endpoint;

//Endpoint é o ponto final onde os nossos usuários acessam nossa API
// Tudo o que for relacionado a estudante, disponível para acesso via web, será feita nessa classe endpoint
// Por isso, esse endpoint é um @RestController


import com.viniciusgomes.error.CustomErrorType;
import com.viniciusgomes.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.viniciusgomes.repository.StudentRepository;

import java.util.Optional;

@RestController // devolve um dado JSON e não uma view
// Se estiver usando MVC, usa-se @Controller ao invés de @RestController
@RequestMapping("students") // Como se faz para chegar nesse endpoint, nesse caso pelo nome students
public class StudentEndpoint {

    private  final StudentRepository studentDao;

    @Autowired // Marca um ponto de injeção usado pelo Spring para injetar (dar new) na classe DateUtil
    public StudentEndpoint(StudentRepository studentDao) {
        this.studentDao = studentDao;
    }

//    @RequestMapping(method = RequestMethod.GET) // Ponto de acesso ao método listAll
    // method mostra que o método HTTP para acesso a esse estudante é por meio de GET
    @GetMapping
    public ResponseEntity<?> listAll () {
        // System.out.println("Data: -> " + dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity<>(studentDao.findAll(), HttpStatus.OK); //retorna a lista de estudantes e o status da requisição
        // a um cliente que fez uma requisição
    }


//    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    // path mostra qual o caminho percorrido para chegar no método por meio da URL
    @GetMapping(path = "/{id")
    public ResponseEntity<?> getStudentById (@PathVariable("id") Long id) { //Apenas GET possuem variáveis no path

        Optional<Student> student = studentDao.findById(id);

        if(!student.isPresent()) {
            return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }

    // POST usado para criar novos objetos (POST não é idempotente)
    // PUT usado para atualizar dados
    // DELETE usado para deletar recursos no servidor
//    @RequestMapping(method = RequestMethod.POST) // não precisamos do path, pq se o cliente fizer uma requisição POST, ele quer criar objeto
    @PostMapping
    public ResponseEntity<?> save (@RequestBody Student student) { //@RequestBody para pega o objeto que vem pelo POST
        return new ResponseEntity<>(studentDao.save(student), HttpStatus.OK); //save do studentDao salva e retorna o valor
    }

//    @RequestMapping (method = RequestMethod.DELETE)
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        studentDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @RequestMapping (method = RequestMethod.PUT)
    @PutMapping
    public ResponseEntity<?> update (@RequestBody Student student) {
        studentDao.save(student); // é o mesmo que o de inserção. A diferença é que o student com id será atualizado, sem id
        // será cadastrado
        return new ResponseEntity<>(HttpStatus.OK); // não retorno nada, pq ao fazer uma alteração, a pessoa já tem os valores
        // que ela espera que o recurso tenha
    }
}
