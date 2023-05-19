package com.yuu.mygym.controller.admin;

import com.yuu.mygym.pojo.Coach;
import com.yuu.mygym.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CoachController {
    CoachService coachService;

    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("/coach")
    public String coaches(Model model){
        List<Coach> coaches = coachService.showCoach();
        model.addAttribute("coaches", coaches);
        return "admin/coach";
    }

    @GetMapping("/coach/input")
    public String toAddCoach(Model model){
        model.addAttribute("coach", new Coach());   //返回一个type对象给前端th:object
        return "admin/coach-input";
    }

    @GetMapping("/coach/{id}/input")
    public String toEditeCoach(@PathVariable Long id, Model model){
        model.addAttribute("coach", coachService.getCoach(id));
        return "admin/coach-input";
    }

    @PostMapping("/coach")
    public String addCoach(@ModelAttribute("coach") Coach coach, RedirectAttributes attributes){   //新增
        attributes.addFlashAttribute("msg", "添加成功");
        coachService.addCoach(coach);
        return "redirect:/admin/coach";   //不能直接跳转到types页面，否则不会显示type数据(没经过types方法)
    }

    @PostMapping("/coach/{id}")
    public String editCoach(@PathVariable Long id, @ModelAttribute("coach") Coach coach, RedirectAttributes attributes){  //修改
        attributes.addFlashAttribute("msg", "修改成功");
        coachService.updateCoach(coach);
        return "redirect:/admin/coach";   //不能直接跳转到types页面，否则不会显示type数据(没经过types方法)
    }

    @GetMapping("/coach/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        coachService.deleteCoach(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/coach";
    }
}
