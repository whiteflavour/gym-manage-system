package com.yuu.mygym.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {
    private Long id;
    private String username;
    private String password;
    private Date createTime;
    private Date updateTime;
}
