package com.example.demo.service.user;

import com.example.demo.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void deleteById(int id);

    User save(User user);
}
