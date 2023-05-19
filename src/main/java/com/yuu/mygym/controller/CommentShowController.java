package com.yuu.mygym.controller;

import com.yuu.mygym.pojo.Comment;
import com.yuu.mygym.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CommentShowController {
    private final CommentService commentService;

    /**
     * Constructor-based dependency injection.
     */
    @Autowired
    public CommentShowController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/comment")
    public String showComment(Model model) {
        List<Comment> comments = commentService.showComment();
        model.addAttribute("comments", comments);
        return "comment";
    }

    @GetMapping("/comment/input")
    public String toAddComment(Model model) {
        model.addAttribute("comment", new Comment());
        return "comment-input";
    }

    @PostMapping("/comment")
    public String addComment(@ModelAttribute("comment") Comment comment, Model model) {
        model.addAttribute("msg", "添加成功");
        commentService.addComment(comment);
        return "redirect:/comment";
    }
}
