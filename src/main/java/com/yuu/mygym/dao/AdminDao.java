package com.yuu.mygym.dao;

import com.yuu.mygym.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao {
    Admin queryByUsernameAndPassword(String username, String password);
}
