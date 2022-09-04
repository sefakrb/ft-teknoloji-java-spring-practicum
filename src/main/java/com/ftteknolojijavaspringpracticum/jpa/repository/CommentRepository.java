package com.ftteknolojijavaspringpracticum.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftteknolojijavaspringpracticum.jpa.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByUserId(Integer id);

    List<Comment> findByProductId(Integer id);

}