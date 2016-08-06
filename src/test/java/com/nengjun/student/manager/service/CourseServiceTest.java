package com.nengjun.student.manager.service;

import com.nengjun.student.manager.AbstractTest;
import com.nengjun.student.manager.entity.Course;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Henry on 16/8/6.
 */
public class CourseServiceTest extends AbstractTest {
    @Autowired
    private CourseService courseService;

    @Test
    public void test() {
        Course course = courseService.getCoursebyId(1);
        System.out.println(course);
    }
}
