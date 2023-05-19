package com.yuu.mygym.controller;

import com.yuu.mygym.pojo.Course;
import com.yuu.mygym.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Course Controller, because courses are showed
 * in homepage.
 *
 * @author Yuu
 * @time 2023年4月13日 15点00分
 */
@Controller
public class HomeController {
    private final CourseService courseService;

    @Autowired
    public HomeController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/")
    public String showCourse(Model model) {
        List<Course> courses = courseService.showCourse();
        model.addAttribute("courses", courses);
        return "index";
    }
}
