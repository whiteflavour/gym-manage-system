package com.yuu.mygym.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
    private Long id;
    private String title;
    private String content;
    private Date createTime;
    private Date updateTime;
}
