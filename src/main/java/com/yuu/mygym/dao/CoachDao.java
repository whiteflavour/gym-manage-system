package com.yuu.mygym.dao;

import com.yuu.mygym.pojo.Coach;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CoachDao {
    List<Coach> queryAll();

    Coach queryById(Long id);

    int addCoach(Coach coach);

    int updateCoach(Coach coach);

    int delete(Long id);
}
