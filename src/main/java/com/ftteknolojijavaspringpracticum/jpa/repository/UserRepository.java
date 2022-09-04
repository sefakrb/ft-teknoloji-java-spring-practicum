package com.ftteknolojijavaspringpracticum.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftteknolojijavaspringpracticum.jpa.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findById(Integer id);

}