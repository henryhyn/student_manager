package com.bestv.action;

import com.bestv.database.model.Student;
import com.bestv.service.StudentManager;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 13-10-24
 * Time: 下午12:35
 * To change this template use File | Settings | File Templates.
 */
public class StudentAction extends ActionSupport {
    private Student student;
    private List<Student> studentList;

    private StudentManager studentManager;

    public String index() {
        studentList = studentManager.findAll();
        return SUCCESS;
    }

    public String show() {
        student = studentManager.find(student.getId());
        return SUCCESS;
    }

    public String add() {
        return INPUT;
    }

    public String create() {
        studentManager.create(getStudent());
        return SUCCESS;
    }

    public String edit() {
        student = studentManager.find(student.getId());
        return INPUT;
    }

    public String update() {
        studentManager.update(student);
        return SUCCESS;
    }

    public String destroy() {
        studentManager.destroy(student);
        return SUCCESS;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public StudentManager getStudentManager() {
        return studentManager;
    }

    public void setStudentManager(StudentManager studentManager) {
        this.studentManager = studentManager;
    }
}
