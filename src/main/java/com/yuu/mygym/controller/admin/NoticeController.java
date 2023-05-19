package com.yuu.mygym.controller.admin;

import com.yuu.mygym.pojo.Notice;
import com.yuu.mygym.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class NoticeController {
    private final NoticeService noticeService;

    @Autowired
    public NoticeController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/notice")
    public String notices(Model model){
        List<Notice> notices = noticeService.showNotice();
        model.addAttribute("notices", notices);
        return "admin/notice";
    }

    @GetMapping("/notice/input")
    public String toAddNotice(Model model){
        model.addAttribute("notice", new Notice());   //返回一个type对象给前端th:object
        return "admin/notice-input";
    }

    @GetMapping("/notice/{id}/input")
    public String toEditeNotice(@PathVariable Long id, Model model){
        model.addAttribute("notice", noticeService.getNotice(id));
        return "admin/notice-input";
    }

    @PostMapping("/notice")
    public String addNotice(@ModelAttribute("notice") Notice notice, RedirectAttributes attributes){   //新增
        attributes.addFlashAttribute("msg", "添加成功");
        noticeService.addNotice(notice);
        return "redirect:/admin/notice";   //不能直接跳转到types页面，否则不会显示type数据(没经过types方法)
    }

    @PostMapping("/notice/{id}")
    public String editNotice(@PathVariable Long id, @ModelAttribute("notice") Notice notice, RedirectAttributes attributes){  //修改
        attributes.addFlashAttribute("msg", "修改成功");
        noticeService.updateNotice(notice);
        return "redirect:/admin/notice";   //不能直接跳转到types页面，否则不会显示type数据(没经过types方法)
    }

    @GetMapping("/notice/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        noticeService.deleteNotice(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/notice";
    }
}
