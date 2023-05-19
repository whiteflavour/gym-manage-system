package com.yuu.mygym.service.impl;

import com.yuu.mygym.dao.AdminDao;
import com.yuu.mygym.pojo.Admin;
import com.yuu.mygym.service.AdminService;
import com.yuu.mygym.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminDao adminDao;

    @Autowired
    public AdminServiceImpl(AdminDao adminDao) {
        this.adminDao = adminDao;
    }

    @Override
    public Admin checkAdmin(String username, String password) {
        return adminDao.queryByUsernameAndPassword(username, MD5Utils.code(password));
    }
}
