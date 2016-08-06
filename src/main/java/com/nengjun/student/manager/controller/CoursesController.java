package com.nengjun.student.manager.controller;

import com.nengjun.student.manager.entity.Course;
import com.nengjun.student.manager.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Henry on 15/9/5.
 */
@Controller
@RequestMapping("/courses")
public class CoursesController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CourseService courseService;

    // 处理 /courses/view1?courseId=123 形式的 URL
    @RequestMapping("/view1")
    public String show1(@RequestParam Integer courseId, Model model) {
        logger.debug("Show course, courseId = {}", courseId);
        Course course = courseService.getCoursebyId(courseId);
        model.addAttribute(course);
        return "courses/show";
    }

    // 处理 /courses/view2/123 形式的 URL
    @RequestMapping(value = "/view2/{courseId}", method = RequestMethod.GET)
    public String show2(@PathVariable("courseId") Integer courseId, Map<String, Object> model) {
        logger.debug("Show course, courseId = {}", courseId);
        Course course = courseService.getCoursebyId(courseId);
        model.put("course", course);
        return "courses/show";
    }

    // 处理 /courses/view3?courseId=123 形式的 URL
    @RequestMapping("/view3")
    public String show3(HttpServletRequest request) {
        Integer courseId = Integer.valueOf(request.getParameter("courseId"));
        logger.debug("Show course, courseId = {}", courseId);
        Course course = courseService.getCoursebyId(courseId);
        request.setAttribute("course", course);
        return "courses/show";
    }

    @RequestMapping(value = "/{courseId}", method = RequestMethod.GET)
    public
    @ResponseBody
    Course getCourseInJson(@PathVariable Integer courseId) {
        return courseService.getCoursebyId(courseId);
    }

    @RequestMapping(value = "/json/{courseId}", method = RequestMethod.GET)
    public ResponseEntity<Course> getCourseInJson2(@PathVariable Integer courseId) {
        Course course = courseService.getCoursebyId(courseId);
        return new ResponseEntity<Course>(course, HttpStatus.OK);
    }
}
