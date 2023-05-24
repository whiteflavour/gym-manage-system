package com.yuu.mygym.controller.admin;

import com.yuu.mygym.pojo.Course;
import com.yuu.mygym.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CourseController {
    CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/course")
    public String courses(Model model){
        List<Course> courses = courseService.showCourse();
        model.addAttribute("courses", courses);
        return "admin/course";
    }

    @GetMapping("/course/input")
    public String toAddCourse(Model model){
        model.addAttribute("course", new Course());   //返回一个type对象给前端th:object
        return "admin/course-input";
    }

    @GetMapping("/course/{id}/input")
    public String toEditeCourse(@PathVariable Long id, Model model){
        model.addAttribute("course", courseService.getCourse(id));
        return "admin/course-input";
    }

    @PostMapping("/course")
    public String addCourse(@ModelAttribute("course") Course course, RedirectAttributes attributes){   //新增
        Course c = courseService.getCourseByName(course.getCourseName());
        if(c != null){
            attributes.addFlashAttribute("msg", "不能添加重复的课程");
            return "redirect:/admin/course/input";
        }else {
            attributes.addFlashAttribute("msg", "添加成功");
        }
        courseService.addCourse(course);
        return "redirect:/admin/course";   //不能直接跳转到types页面，否则不会显示type数据(没经过types方法)
    }

    @PostMapping("/course/{id}")
    public String editCourse(@PathVariable Long id, @ModelAttribute("course") Course course, RedirectAttributes attributes){  //修改
        Course c = courseService.getCourseByName(course.getCourseName());
        if(c != null){
            attributes.addFlashAttribute("msg", "修改后与修改前结果一致");
            return "redirect:/admin/course/{id}/input";
        }else {
            attributes.addFlashAttribute("msg", "修改成功");
        }
        courseService.updateCourse(course);
        return "redirect:/admin/course";   //不能直接跳转到types页面，否则不会显示type数据(没经过types方法)
    }

    @GetMapping("/course/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        courseService.deleteCourse(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/course";
    }
}
