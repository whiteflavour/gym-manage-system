package com.yuu.mygym.service.impl;

import com.yuu.mygym.dao.CourseDao;
import com.yuu.mygym.pojo.Course;
import com.yuu.mygym.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseDao courseDao;

    /**
     * Constructor-based dependency injection.
     *
     * @param courseDao
     */
    @Autowired
    public CourseServiceImpl(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public List<Course> showCourse() {
        return courseDao.queryAll();
    }

    @Override
    public Course getCourse(Long id) {
        return courseDao.findById(id);
    }

    @Override
    public Course getCourseByName(String courseName) {
        return courseDao.findByName(courseName);
    }

    @Override
    public int addCourse(Course course) {
        return courseDao.addCourse(course);
    }

    @Override
    public int updateCourse(Course course) {
        return courseDao.update(course);
    }

    @Override
    public int deleteCourse(Long id) {
        return courseDao.deleteById(id);
    }
}
