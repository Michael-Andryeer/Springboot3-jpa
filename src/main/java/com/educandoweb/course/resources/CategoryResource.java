// Define o pacote onde a classe está localizada
package com.educandoweb.course.resources;

// Importa a classe Category do pacote entities

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// Define a classe CategoryResource como um controlador REST
@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;

    // Mapeia requisições HTTP GET para o método findAll
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = service.findAll();
        // Retorna uma resposta HTTP 200 (OK) contendo o objeto Category no corpo da resposta
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
/*
Explicação das anotações e classes usadas:

    @RestController: Indica que a classe é um controlador REST onde cada método retorna um objeto de domínio em vez de uma visão.
    @RequestMapping(value = "/Categorys"): Mapeia requisições HTTP para URLs que começam com "/Categorys" para métodos nesta classe.
    @GetMapping: Mapeia requisições HTTP GET para o método anotado.
    ResponseEntity: Utilizado para manipular a resposta HTTP de maneira mais detalhada, permitindo definir o corpo, status e cabeçalhos da resposta.

O método findAll cria um objeto Category com dados fictícios e retorna este objeto em uma resposta HTTP 200 (OK).
*/