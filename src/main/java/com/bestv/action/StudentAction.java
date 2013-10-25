package com.bestv.action;

import com.bestv.database.model.Student;
import com.bestv.service.StudentService;
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

    private StudentService studentService;

    public String index() {
        studentList = studentService.findAll();
        return SUCCESS;
    }

    public String show() {
        studentService.load(student, student.getId());
        return SUCCESS;
    }

    public String add() {
        return INPUT;
    }

    public String create() {
        studentService.save(student);
        return SUCCESS;
    }

    public String edit() {
        studentService.load(student, student.getId());
        return INPUT;
    }

    public String update() {
        studentService.update(student);
        return SUCCESS;
    }

    public String destroy() {
        studentService.delete(student);
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

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
