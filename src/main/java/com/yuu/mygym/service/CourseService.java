package com.yuu.mygym.service;

import com.yuu.mygym.pojo.Course;

import java.util.List;

public interface CourseService {
    List<Course> showCourse();

    Course getCourse(Long id);

    Course getCourseByName(String courseName);

    int addCourse(Course course);

    int updateCourse(Course course);

    int deleteCourse(Long id);
}
