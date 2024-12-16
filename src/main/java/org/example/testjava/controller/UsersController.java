package org.example.testjava.controller;

import lombok.RequiredArgsConstructor;
import org.example.testjava.entity.Users;
import org.example.testjava.repository.UsersRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UsersController {
    private final UsersRepository usersRepository;

    @GetMapping
    public List<Users> getAll() {
        return usersRepository.findAll();
    }
}