package com.yuu.mygym.service;

import com.yuu.mygym.pojo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> showComment();

    Comment getComment(Long id);

    int addComment(Comment comment);

    int updateComment(Comment comment);

    int deleteComment(Long id);
}
