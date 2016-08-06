package com.nengjun.student.manager.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Henry on 16/8/6.
 */
@Data
@Entity
public class Section {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer courseId;
    private Integer chapterId;
    private Integer order;
    private String title;
    private Integer type;
    private String duration;
    private String filePath;
}
