package com.ftteknolojijavaspringpracticum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftteknolojijavaspringpracticum.jpa.model.User;
import com.ftteknolojijavaspringpracticum.jpa.repository.UserRepository;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public @ResponseBody User addUser(User user) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setEmail(user.getEmail());
        newUser.setTelephoneNumber(user.getTelephoneNumber());
        userRepository.save(newUser);
        return newUser;
    }

    public @ResponseBody List<User> getAllUsers() {

        return userRepository.findAll();
    }
}