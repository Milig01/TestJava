package org.example.testjava;

import org.example.testjava.entity.Users;
import org.example.testjava.repository.UsersRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TestJavaApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TestJavaApplication.class, args);
        UsersRepository usersRepository = context.getBean(UsersRepository.class);
        usersRepository.save(Users.builder().name("Jack").build());
        usersRepository.save(Users.builder().name("Tom").build());
    }
}