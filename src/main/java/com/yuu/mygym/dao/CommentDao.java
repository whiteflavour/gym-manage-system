package com.yuu.mygym.dao;

import com.yuu.mygym.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDao {
    List<Comment> queryAll();

    Comment queryById(Long id);

    int add(Comment comment);

    int update(Comment comment);

    int delete(Long id);
}
