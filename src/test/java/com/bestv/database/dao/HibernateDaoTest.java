package com.bestv.database.dao;

import com.bestv.database.vo.Student;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: henry
 * Date: 13-10-25
 * Time: 下午12:11
 * To change this template use File | Settings | File Templates.
 */
public class HibernateDaoTest {
    @Test
    public void test() {
        List<Object> students = HibernateDao.getInstance().findAll(Student.class);
        for (Object object : students) {
            System.out.println(((Student)object).getName());
        }
        Student student = (Student) HibernateDao.getInstance().find(Student.class, 1);
        System.out.println(student.getName());
        HibernateDao.getInstance().save(student);
        student.setName("Richard");
        HibernateDao.getInstance().update(student);
        HibernateDao.getInstance().delete(student);
    }
}
