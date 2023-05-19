package com.yuu.mygym.service.impl;

import com.yuu.mygym.dao.CoachDao;
import com.yuu.mygym.pojo.Coach;
import com.yuu.mygym.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachServiceImpl implements CoachService {
    private final CoachDao coachDao;

    /**
     * Constructor-based dependency injection.
     *
     * @param coachDao
     */
    @Autowired
    public CoachServiceImpl(CoachDao coachDao) {
        this.coachDao = coachDao;
    }

    @Override
    public List<Coach> showCoach() {
        return coachDao.queryAll();
    }

    @Override
    public Coach getCoach(Long id) {
        return coachDao.queryById(id);
    }

    @Override
    public int addCoach(Coach coach) {
        return coachDao.addCoach(coach);
    }

    @Override
    public int updateCoach(Coach coach) {
        return coachDao.updateCoach(coach);
    }

    @Override
    public int deleteCoach(Long id) {
        return coachDao.delete(id);
    }
}
