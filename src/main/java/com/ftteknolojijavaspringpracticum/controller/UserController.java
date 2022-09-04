package com.ftteknolojijavaspringpracticum.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftteknolojijavaspringpracticum.dto.UserDto;
import com.ftteknolojijavaspringpracticum.jpa.model.User;
import com.ftteknolojijavaspringpracticum.service.UserService;

@Controller
@RequestMapping(path = "/demo")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(path = "/add-user")
    public @ResponseBody UserDto addUser(@RequestBody UserDto userDto) {
        User user = convertToEntity(userDto);
        User userCreated = userService.addUser(user);
        return convertToDto(userCreated);
    }

    @GetMapping(path = "/all-user")
    public @ResponseBody List<UserDto> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private UserDto convertToDto(User user) {

        UserDto dto = new UserDto();
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setEmail(user.getEmail());
        dto.setTelephoneNumber(user.getTelephoneNumber());

        return dto;
    }

    private User convertToEntity(UserDto userDto) {

        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setTelephoneNumber(userDto.getTelephoneNumber());

        return user;
    }
}