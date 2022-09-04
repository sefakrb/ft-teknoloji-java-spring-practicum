package com.ftteknolojijavaspringpracticum.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftteknolojijavaspringpracticum.jpa.model.Comment;
import com.ftteknolojijavaspringpracticum.jpa.repository.CommentRepository;

@Component
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public @ResponseBody Comment addComment(Comment comment) {
        Comment newComment = new Comment();
        newComment.setProductComment(comment.getProductComment());
        newComment.setCommentDate(comment.getCommentDate());
        newComment.setUser(comment.getUser());
        newComment.setProduct(comment.getProduct());
        commentRepository.save(newComment);
        return newComment;
    }

    public @ResponseBody List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public @ResponseBody List<Comment> getCommentsByUserId(Integer userId) {
        return commentRepository.findByUserId(userId);
    }

    public @ResponseBody List<Comment> getUserCommentsByDate(Integer id, Date startDate, Date endDate) {
        List<Comment> userComment = commentRepository.findByUserId(id);
        List<Comment> filteredComments = new ArrayList<>();
        for (int index = 0; index < userComment.size(); index++) {
            if (startDate.getTime() < userComment.get(index).getCommentDate().getTime() &&
                    userComment.get(index).getCommentDate().getTime() < endDate.getTime()) {
                filteredComments.add(userComment.get(index));
            }
        }
        return filteredComments;
    }

    public @ResponseBody List<Comment> getCommentsByDate(Integer productId, Date startDate, Date endDate) {
        List<Comment> productComment = commentRepository.findByProductId(productId);
        List<Comment> filteredComments = new ArrayList<>();
        for (int index = 0; index < productComment.size(); index++) {
            if (startDate.getTime() < productComment.get(index).getCommentDate().getTime() &&
                    productComment.get(index).getCommentDate().getTime() < endDate.getTime()) {
                filteredComments.add(productComment.get(index));
            }
        }
        return filteredComments;
    }

}