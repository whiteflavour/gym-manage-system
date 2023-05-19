package com.yuu.mygym.controller;

import com.yuu.mygym.pojo.Notice;
import com.yuu.mygym.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class NoticeShowController {
    private final NoticeService noticeService;

    /**
     * Constructor-based dependency injection.
     *
     * @param noticeService
     */
    @Autowired
    public NoticeShowController(NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/notice")
    public String showNotice(Model model) {
        List<Notice> notices = noticeService.showNotice();
        model.addAttribute("notices", notices);
        return "notice";
    }

    @GetMapping("/notice/{id}")
    public String showNoticeContent(@PathVariable("id") Long id, Model model) {
        Notice notice = noticeService.getNotice(id);
        model.addAttribute("notice", notice);
        return "notice-content";
    }
}
