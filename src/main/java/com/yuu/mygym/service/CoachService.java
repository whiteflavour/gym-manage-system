package com.yuu.mygym.service;

import com.yuu.mygym.pojo.Coach;

import java.util.List;

public interface CoachService {
    List<Coach> showCoach();

    Coach getCoach(Long id);

    int addCoach(Coach coach);

    int updateCoach(Coach coach);

    int deleteCoach(Long id);
}
