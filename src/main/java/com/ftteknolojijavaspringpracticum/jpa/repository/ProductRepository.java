package com.ftteknolojijavaspringpracticum.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftteknolojijavaspringpracticum.jpa.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(Integer id);

}