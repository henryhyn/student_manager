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
public class Student {
    @Id
    @GeneratedValue
    private Long id;
    private Integer classId;
    private String name;
    private String number;
}
