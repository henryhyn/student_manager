package com.bestv.service;

import com.bestv.database.dao.StudentDao;
import com.bestv.database.model.Student;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 13-10-25
 * Time: 下午4:40
 * To change this template use File | Settings | File Templates.
 */
public class StudentManager {
    private StudentDao studentDao;

    public List<Student> findAll() {
        List<Student> students = studentDao.findAll();
        return students;
    }

    public Student find(Integer id) {
        Student student = studentDao.find(id);
        return student;
    }

    public boolean create(Student student) {
        studentDao.save(student);
        return true;
    }

    public boolean update(Student student) {
        studentDao.update(student);
        return true;
    }

    public boolean destroy(Student student) {
        studentDao.delete(student);
        return true;
    }

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
