package com.nengjun.student.manager.dao;

import com.nengjun.student.manager.AbstractTest;
import com.nengjun.student.manager.entity.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Henry on 16/8/6.
 */
public class StudentDaoTest extends AbstractTest {
    @Autowired
    private StudentDao studentDao;

    @Test
    public void test() {
        Student student = studentDao.first();
        System.out.println(student);
    }
}
