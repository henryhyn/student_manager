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
public class Chapter {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer courseId;
    private Integer order;
    private String title;
    private String descr;
}
