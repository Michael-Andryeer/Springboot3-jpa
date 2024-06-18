// Define o pacote onde a classe está localizada
package com.educandoweb.course.resources;

// Importa a classe User do pacote entities
import com.educandoweb.course.entities.User;
// Importa a classe ResponseEntity do pacote org.springframework.http para manipular respostas HTTP
import org.springframework.http.ResponseEntity;
// Importa a anotação GetMapping do pacote org.springframework.web.bind.annotation para mapear requisições HTTP GET
import org.springframework.web.bind.annotation.GetMapping;
// Importa a anotação RequestMapping do pacote org.springframework.web.bind.annotation para mapear requisições HTTP para um controlador específico
import org.springframework.web.bind.annotation.RequestMapping;
// Importa a anotação RestController do pacote org.springframework.web.bind.annotation para definir a classe como um controlador REST
import org.springframework.web.bind.annotation.RestController;

// Define a classe UserResource como um controlador REST
@RestController
@RequestMapping(value = "/users")
public class UserResource {
    // Mapeia requisições HTTP GET para o método findAll
    @GetMapping
    public ResponseEntity<User> findAll() {
        // Cria uma nova instância de User com dados fictícios
        User user = new User(1L, "Michael", "Michael@gmail.com", "99999", "12345");
        // Retorna uma resposta HTTP 200 (OK) contendo o objeto User no corpo da resposta
        return ResponseEntity.ok().body(user);
    }
}
/*
Explicação das anotações e classes usadas:

    @RestController: Indica que a classe é um controlador REST onde cada método retorna um objeto de domínio em vez de uma visão.
    @RequestMapping(value = "/users"): Mapeia requisições HTTP para URLs que começam com "/users" para métodos nesta classe.
    @GetMapping: Mapeia requisições HTTP GET para o método anotado.
    ResponseEntity: Utilizado para manipular a resposta HTTP de maneira mais detalhada, permitindo definir o corpo, status e cabeçalhos da resposta.

O método findAll cria um objeto User com dados fictícios e retorna este objeto em uma resposta HTTP 200 (OK).
*/