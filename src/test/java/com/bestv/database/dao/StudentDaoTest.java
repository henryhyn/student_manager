package com.bestv.database.dao;

import com.bestv.database.vo.Student;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: richard
 * Date: 13-10-17
 * Time: 上午1:08
 * To change this template use File | Settings | File Templates.
 */
public class StudentDaoTest {
    @Test
    public void test() {
        List<Student> students = DaoFactory.getStudentDao().findAll();
        for (Student student : students) {
            System.out.println(student.getName());
        }
    }
}
