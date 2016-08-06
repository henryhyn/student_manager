package com.nengjun.student.manager.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Henry on 16/8/6.
 */
@Data
@Entity
public class Course {
    // 课程Id
    @Id
    @GeneratedValue
    private Integer courseId;
    // 课程名称
    private String title;
    // 图片路径
    private String imgPath;
    // 学习人数
    private Integer learningNum;
    // 课程时长
    private Long duration;
    // 课程难度
    private Integer level;
    // 课程难度描述
    private String levelDesc;
    // 课程介绍
    private String descr;
    // 课程提纲
    @OneToMany
    private List<Chapter> chapterList;
}
