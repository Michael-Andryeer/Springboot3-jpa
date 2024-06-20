package com.educandoweb.course.config;

import com.educandoweb.course.entities.*;
import com.educandoweb.course.entities.enums.OrderStatus;
import com.educandoweb.course.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null,"Books");
        Category cat2 = new Category(null,"Computers");
        Category cat3 = new Category(null,"Eletronics");

        Product p1 = new Product(null,"Humano demasiado humano","Filosofia",90.0,"");
        Product p2 = new Product(null,"Notebook positivo","Notebook positivo com 8gb de ram",900.0,"");
        Product p3 = new Product(null,"Smart TV","Televisao",1590.0,"");
        Product p4 = new Product(null,"Democracia, o Deus que falhou","Filosofia politica",100.0,"");
        Product p5 = new Product(null,"PC Gamer","Computador gamer",5960.0,"");


        categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));

        p1.getCategories().add(cat1);
        p2.getCategories().add(cat2);
        p3.getCategories().add(cat3);
        p4.getCategories().add(cat1);
        p5.getCategories().add(cat2);

        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));


        User u1 = new User(null, "Vitoria Luz", "vitoria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Michael Andryeer", "andryeerm@gmail.com", "977777777", "123456");

        Order o1 =  new Order (null, Instant.parse("2024-06-15T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 =  new Order (null, Instant.parse("2024-06-15T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u2);
        Order o3 =  new Order (null, Instant.parse("2024-06-15T19:53:07Z"), OrderStatus.WAITING_PAYMENT, u2);

        userRepository.saveAll(Arrays.asList(u1,u2));
        orderRepository.saveAll(Arrays.asList(o1,o2,o3));

        OrderItem oi1 = new OrderItem(o1,p1,2,p1.getPrice());
        OrderItem oi2 = new OrderItem(o1,p3,1,p3.getPrice());
        OrderItem oi3 = new OrderItem(o2,p3,2,p3.getPrice());
        OrderItem oi4 = new OrderItem(o3,p5,2,p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));

    }
}
