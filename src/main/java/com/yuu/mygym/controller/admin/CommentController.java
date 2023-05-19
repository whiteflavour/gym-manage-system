package com.yuu.mygym.controller.admin;

import com.yuu.mygym.pojo.Comment;
import com.yuu.mygym.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comment")
    public String comments(Model model){
        List<Comment> comments = commentService.showComment();
        model.addAttribute("comments", comments);
        return "admin/comment";
    }

    @GetMapping("/comment/input")
    public String toAddComment(Model model){
        model.addAttribute("comment", new Comment());   //返回一个type对象给前端th:object
        return "admin/comment-input";
    }

    @GetMapping("/comment/{id}/input")
    public String toEditeComment(@PathVariable Long id, Model model){
        model.addAttribute("comment", commentService.getComment(id));
        return "admin/comment-input";
    }

    @PostMapping("/comment")
    public String addComment(@ModelAttribute("comment") Comment comment, RedirectAttributes attributes){   //新增
        attributes.addFlashAttribute("msg", "添加成功");
        commentService.addComment(comment);
        return "redirect:/admin/comment";   //不能直接跳转到types页面，否则不会显示type数据(没经过types方法)
    }

    @PostMapping("/comment/{id}")
    public String editComment(@PathVariable Long id, @ModelAttribute("comment") Comment comment, RedirectAttributes attributes){  //修改
        attributes.addFlashAttribute("msg", "修改成功");
        commentService.updateComment(comment);
        return "redirect:/admin/comment";   //不能直接跳转到types页面，否则不会显示type数据(没经过types方法)
    }

    @GetMapping("/comment/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        commentService.deleteComment(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/comment";
    }
}
