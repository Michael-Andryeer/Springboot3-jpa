// Define o pacote onde a classe está localizada
package com.educandoweb.course.resources;

// Importa a classe User do pacote entities
import com.educandoweb.course.entities.User;
// Importa a classe ResponseEntity do pacote org.springframework.http para manipular respostas HTTP
import com.educandoweb.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.ResponseEntity;
// Importa a anotação GetMapping do pacote org.springframework.web.bind.annotation para mapear requisições HTTP GET
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
// Importa a anotação RequestMapping do pacote org.springframework.web.bind.annotation para mapear requisições HTTP para um controlador específico
// Importa a anotação RestController do pacote org.springframework.web.bind.annotation para definir a classe como um controlador REST

import java.net.URI;
import java.util.List;

// Define a classe UserResource como um controlador REST
@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    // Mapeia requisições HTTP GET para o método findAll
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        // Retorna uma resposta HTTP 200 (OK) contendo o objeto User no corpo da resposta
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> update (@PathVariable Long id, @RequestBody User obj) {
        obj = service.update(id,obj);
        return ResponseEntity.ok().body(obj);
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