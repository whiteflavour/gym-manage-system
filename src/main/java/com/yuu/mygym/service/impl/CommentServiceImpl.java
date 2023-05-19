package com.yuu.mygym.service.impl;

import com.yuu.mygym.dao.CommentDao;
import com.yuu.mygym.pojo.Comment;
import com.yuu.mygym.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentDao commentDao;

    @Autowired
    public CommentServiceImpl(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Override
    public List<Comment> showComment() {
        return commentDao.queryAll();
    }

    @Override
    public Comment getComment(Long id) {
        return commentDao.queryById(id);
    }

    @Override
    public int addComment(Comment comment) {
        return commentDao.add(comment);
    }

    @Override
    public int updateComment(Comment comment) {
        return commentDao.update(comment);
    }

    @Override
    public int deleteComment(Long id) {
        return commentDao.delete(id);
    }
}
