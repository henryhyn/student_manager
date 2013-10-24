package com.bestv.action;

import com.bestv.database.dao.DaoFactory;
import com.bestv.database.vo.Student;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 13-10-24
 * Time: 下午12:35
 * To change this template use File | Settings | File Templates.
 */
public class StudentAction extends ActionSupport {
    private Student student;

    public String index() {
        return SUCCESS;
    }

    public String show() {
        setStudent(DaoFactory.getStudentDao().find(student.getId()));
        return SUCCESS;
    }

    public String add() {
        return INPUT;
    }

    public String create() {
        DaoFactory.getStudentDao().save(getStudent());
        return SUCCESS;
    }

    public String edit() {
        setStudent(DaoFactory.getStudentDao().find(student.getId()));
        return INPUT;
    }

    public String update() {
        DaoFactory.getStudentDao().update(getStudent());
        return SUCCESS;
    }

    public String destroy() {
        DaoFactory.getStudentDao().delete(getStudent());
        return SUCCESS;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
