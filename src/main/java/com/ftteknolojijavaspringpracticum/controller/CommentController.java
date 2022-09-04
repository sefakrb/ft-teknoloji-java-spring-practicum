package com.ftteknolojijavaspringpracticum.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ftteknolojijavaspringpracticum.dto.CommentDto;
import com.ftteknolojijavaspringpracticum.jpa.model.Comment;
import com.ftteknolojijavaspringpracticum.jpa.model.Product;
import com.ftteknolojijavaspringpracticum.jpa.model.User;
import com.ftteknolojijavaspringpracticum.jpa.repository.ProductRepository;
import com.ftteknolojijavaspringpracticum.jpa.repository.UserRepository;
import com.ftteknolojijavaspringpracticum.service.CommentService;

@Controller
@RequestMapping
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add-comment")
    public @ResponseBody CommentDto addComment(@RequestBody CommentDto commentDto) {
        Comment comment = convertToEntity(commentDto);
        Comment commentCreated = commentService.addComment(comment);
        return convertToDto(commentCreated);
    }

    @GetMapping(path = "/all-comment")
    public @ResponseBody List<CommentDto> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        return comments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/user-comment")
    @ResponseBody
    public List<CommentDto> getUserComments(@RequestParam Integer userId) {
        List<Comment> comments = commentService.getCommentsByUserId(userId);
        return comments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/user-comment-by-date")
    @ResponseBody
    public List<CommentDto> getUserCommentsByDate(@RequestParam Integer userId, @RequestParam String startDate,
            @RequestParam String endDate) throws ParseException {
        Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date end = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        List<Comment> comments = commentService.getUserCommentsByDate(userId, start, end);
        return comments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @GetMapping(path = "/comment-by-date")
    @ResponseBody
    public List<CommentDto> getCommentsByDate(@RequestParam Integer productId, @RequestParam String startDate,
            @RequestParam String endDate) throws ParseException {
        Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date end = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        List<Comment> comments = commentService.getCommentsByDate(productId, start, end);
        return comments.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private CommentDto convertToDto(Comment comment) {
        CommentDto dto = new CommentDto();
        dto.setProductComment(comment.getProductComment());
        dto.setCommentDate(comment.getCommentDate());
        dto.setProductId(comment.getProduct().getId());
        dto.setUserId(comment.getUser().getId());

        return dto;
    }

    private Comment convertToEntity(CommentDto commentDto) {
        Optional<Product> product = productRepository.findById(commentDto.getProductId());
        Optional<User> user = userRepository.findById(commentDto.getUserId());

        Comment comment = new Comment();
        comment.setProductComment(commentDto.getProductComment());
        comment.setCommentDate(commentDto.getCommentDate());
        comment.setProduct(product.get());
        comment.setUser(user.get());

        return comment;
    }
}
