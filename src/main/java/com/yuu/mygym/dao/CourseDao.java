package com.yuu.mygym.dao;

import com.yuu.mygym.pojo.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseDao {
    List<Course> queryAll();

    Course findById(Long id);

    Course findByName(String name);

    int addCourse(Course course);

    int update(Course course);

    int deleteById(Long id);
}
