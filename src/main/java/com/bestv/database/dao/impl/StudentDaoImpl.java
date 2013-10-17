package com.bestv.database.dao.impl;

import com.bestv.database.dao.HibernateDao;
import com.bestv.database.dao.StudentDao;
import com.bestv.database.vo.Student;

import java.util.ArrayList;

/**
 * 节目 DAO 层类
 * User: henry
 * Date: 13-9-11
 * Time: 下午3:59
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public ArrayList<Student> findAll() {
        return HibernateDao.findAll();
    }

    @Override
    public Student find(Integer id) {
        return HibernateDao.find(id);
    }

    @Override
    public void save(Student student) {
        HibernateDao.save(student);
    }

    @Override
    public void update(Student student) {
        HibernateDao.update(student);
    }

    @Override
    public void delete(Student student) {
        HibernateDao.delete(student);
    }
}
