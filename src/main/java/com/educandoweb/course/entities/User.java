// Define o pacote onde a classe está localizada
package com.educandoweb.course.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

// Define a classe User e implementa a interface Serializable para permitir que objetos User sejam serializados
@Entity
@Table(name= "tb_user")
public class User implements Serializable {

    // Define um número de versão para a serialização, garantindo compatibilidade durante o processo de desserialização
    private static final long serialVersionUID = 1L;

    // Define os atributos da classe User
    @Id //usada  para marcar um campo de uma classe de entidade como a chave primária.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // espefica que o valor do identificador primário (no caso, o campo id) deve ser gerado automaticamente pelo provedor de persistência, geralmente um banco de dados.
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    // Construtor vazio necessário para algumas operações de frameworks e bibliotecas
    public User() {}

    // Métodos getters e setters para acessar e modificar os atributos da classe

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Construtor que inicializa todos os atributos da classe
    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    // Sobrescreve o método equals para comparar objetos User com base no atributo id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    // Sobrescreve o método hashCode para gerar um código hash baseado no atributo id
    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

/*
Explicação das principais partes:

    Serializable: Implementa a interface Serializable para permitir que instâncias de User sejam convertidas em um formato de byte stream, facilitando o armazenamento e a transmissão.
    serialVersionUID: Um identificador único para garantir a compatibilidade durante a serialização e desserialização.
    Construtor Padrão: Necessário para frameworks e bibliotecas que utilizam reflexão ou que exigem um construtor sem argumentos.
    Construtor Completo: Inicializa a instância com valores fornecidos para todos os atributos.
    Getters e Setters: Métodos para acessar e modificar os atributos privados da classe.
    equals: Compara dois objetos User para igualdade com base no atributo id.
    hashCode: Retorna um código hash para o objeto, baseado no atributo id.

Esses métodos e atributos são fundamentais para garantir que os objetos User possam ser manipulados corretamente em coleções e outras estruturas que dependem de hashing e comparação de objetos.
 */
