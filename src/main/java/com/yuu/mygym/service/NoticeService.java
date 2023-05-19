package com.yuu.mygym.service;

import com.yuu.mygym.pojo.Notice;

import java.util.List;

public interface NoticeService {
    List<Notice> showNotice();

    Notice getNotice(Long id);

    int addNotice(Notice notice);

    int updateNotice(Notice notice);

    int deleteNotice(Long id);
}
