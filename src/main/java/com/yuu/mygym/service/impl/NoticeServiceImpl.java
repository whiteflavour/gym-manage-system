package com.yuu.mygym.service.impl;

import com.yuu.mygym.dao.NoticeDao;
import com.yuu.mygym.pojo.Notice;
import com.yuu.mygym.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    private final NoticeDao noticeDao;

    /**
     * Constructor-based dependency injection.
     *
     * @param noticeDao
     */
    @Autowired
    public NoticeServiceImpl(NoticeDao noticeDao) {
        this.noticeDao = noticeDao;
    }

    @Override
    public List<Notice> showNotice() {
        return noticeDao.queryAll();
    }

    @Override
    public Notice getNotice(Long id) {
        return noticeDao.queryById(id);
    }

    @Override
    public int addNotice(Notice notice) {
        return noticeDao.add(notice);
    }

    @Override
    public int updateNotice(Notice notice) {
        return noticeDao.update(notice);
    }

    @Override
    public int deleteNotice(Long id) {
        return noticeDao.delete(id);
    }
}
