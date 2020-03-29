package br.com.devdojo.endpoint;

//Endpoint é o ponto final onde os nossos usuários acessam nossa API
// Tudo o que for relacionado a estudante, disponível para acesso via web, será feita nessa classe endpoint
// Por isso, esse endpoint é um @RestController


import br.com.devdojo.model.Student;
import br.com.devdojo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

@RestController // devolve um dado JSON e não uma view
// Se estiver usando MVC, usa-se @Controller ao invés de @RestController
@RequestMapping("student") // Como se faz para chegar nesse endpoint, nesse caso pelo nome student
public class StudentEndpoint {

    @Autowired // faz a injeção de dependência e instancia o objeto, por isso não tenho um new.
    private DateUtil dateUtil;

    @RequestMapping(method = RequestMethod.GET, path = "/list") // Ponto de acesso ao método listAll
    // method mostra que o método HTTP para acesso a esse estudante é por meio de GET
    // path mostra qual o caminho percorrido para chegar no método por meio da URL
    public List<Student> listAll () {
        //System.out.println("Data: -> " + dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return  asList(new Student("Deku"), new Student("Todoroki"));
    }
}
