package com.yuu.mygym.service;

import com.yuu.mygym.pojo.Admin;

public interface AdminService {
    Admin checkAdmin(String username, String password);
}
