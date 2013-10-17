package com.bestv.database.vo;

import javax.persistence.Entity;

/**
 * 节目类
 * User: henry
 * Date: 13-9-11
 * Time: 下午3:54
 */
@Entity
public class Student {
    private Integer id;
    private String name;
    private String number;
    private Integer classId;

    @javax.persistence.Column(name = "id")
    @javax.persistence.Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @javax.persistence.Column(name = "name")
    @javax.persistence.Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @javax.persistence.Column(name = "number")
    @javax.persistence.Basic
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @javax.persistence.Column(name = "class_id")
    @javax.persistence.Basic
    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (classId != null ? !classId.equals(student.classId) : student.classId != null) return false;
        if (id != null ? !id.equals(student.id) : student.id != null) return false;
        if (name != null ? !name.equals(student.name) : student.name != null) return false;
        if (number != null ? !number.equals(student.number) : student.number != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (classId != null ? classId.hashCode() : 0);
        return result;
    }
}
