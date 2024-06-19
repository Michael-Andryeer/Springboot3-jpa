package com.educandoweb.course.config;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.educandoweb.course.repositories.UserRepository;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test") // Rodar esta configuração apenas no perfil de teste
public class TestConfig  implements CommandLineRunner {

    @Autowired // A anotação @Autowired é usada em Spring Framework para injetar automaticamente as dependências em uma classe.
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null,"Books");
        Category cat2 = new Category(null,"Computers");

        categoryRepository.saveAll(Arrays.asList(cat1,cat2));

        User u1 = new User(null, "Vitoria Luz", "vitoria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Michael Andryeer", "andryeerm@gmail.com", "977777777", "123456");

        Order o1 =  new Order (null, Instant.parse("2024-06-15T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 =  new Order (null, Instant.parse("2024-06-15T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u2);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2));
    }
}
