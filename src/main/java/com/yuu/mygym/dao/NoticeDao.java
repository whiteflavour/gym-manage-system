package com.yuu.mygym.dao;

import com.yuu.mygym.pojo.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeDao {
    List<Notice> queryAll();

    Notice queryById(Long id);

    int add(Notice notice);

    int update(Notice notice);

    int delete(Long id);
}
