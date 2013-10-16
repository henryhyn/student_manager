package com.bestv.database.vo;

/**
 * 节目类
 * User: henry
 * Date: 13-9-11
 * Time: 下午3:54
 */
public class Student {
    private Integer id;
    private String name;
    private String number;
    private Integer classId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}
