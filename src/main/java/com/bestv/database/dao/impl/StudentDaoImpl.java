package com.bestv.database.dao.impl;

import com.bestv.database.dao.HibernateDao;
import com.bestv.database.dao.StudentDao;
import com.bestv.database.vo.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * 节目 DAO 层类
 * User: henry
 * Date: 13-9-11
 * Time: 下午3:59
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public ArrayList<Student> findAll() {
        List<Object> objects = HibernateDao.getInstance().findAll(Student.class);
        ArrayList<Student> students = new ArrayList<Student>();
        for (Object object : objects) {
            students.add((Student)object);
        }
        return students;
    }

    @Override
    public Student find(Integer id) {
        return (Student) HibernateDao.getInstance().find(Student.class, id);
    }

    @Override
    public void save(Student student) {
        HibernateDao.getInstance().save(student);
    }

    @Override
    public void update(Student student) {
        HibernateDao.getInstance().update(student);
    }

    @Override
    public void delete(Student student) {
        HibernateDao.getInstance().delete(student);
    }
}
