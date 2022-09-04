package com.ftteknolojijavaspringpracticum.dto;

import java.sql.Date;

public class CommentDto {
    private String productComment;
    private Date commentDate;
    private Integer productId;
    private Integer userId;

    public String getProductComment() {
        return this.productComment;
    }

    public void setProductComment(String productComment) {
        this.productComment = productComment;
    }

    public Date getCommentDate() {
        return this.commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getProductId() {
        return this.productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}