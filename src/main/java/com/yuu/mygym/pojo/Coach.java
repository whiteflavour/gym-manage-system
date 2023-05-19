package com.yuu.mygym.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coach {
    private Long id;
    private String name;
    private String gender;
    private int experience;
    private Date createTime;
    private Date updateTime;
}
