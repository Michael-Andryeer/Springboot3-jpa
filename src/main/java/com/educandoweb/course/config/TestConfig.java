package com.educandoweb.course.config;

import com.educandoweb.course.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.educandoweb.course.repositories.UserRepository;

import java.util.Arrays;

@Configuration
@Profile("test") // Rodar esta configuração apenas no perfil de teste
public class TestConfig  implements CommandLineRunner {

    @Autowired // A anotação @Autowired é usada em Spring Framework para injetar automaticamente as dependências em uma classe.
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Vitoria Luz", "vitoria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Michael Andryeer", "andryeerm@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));
    }
}
