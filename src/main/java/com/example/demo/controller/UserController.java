package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    IUserService userRepository;

    @RequestMapping("/get")
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @PostMapping("/insert")
    public User insert(@RequestBody User user) {
        System.out.println(user.getId());
        return userRepository.save(user);
    }

    @RequestMapping("/update")
    public User update(@RequestBody User user, @RequestParam("id") int id) {
        user.setId(id);
        return userRepository.save(user);
    }

    @RequestMapping("/del")
    public void del(@RequestParam("id") int id){
        userRepository.deleteById(id);
    }
}
