package com.nengjun.student.manager.controller.admin;

import com.nengjun.student.manager.entity.Course;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by Henry on 15/9/6.
 */
@Controller
@RequestMapping("/admin/courses")
public class AdminCoursesController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/new")
    public String _new() {
        return "admin/courses/form";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute Course course) {
        logger.debug("Info of Course: {}", ReflectionToStringBuilder.toString(course));
        course.setCourseId(123);
        return "redirect:/courses/view2/" + course.getCourseId();
    }

    @RequestMapping(value = "/file", method = RequestMethod.GET)
    public String file(@RequestParam(value = "multi", required = false) Boolean multi) {
        if (multi != null && multi) {
            return "admin/courses/multi_file";
        }
        return "admin/courses/file";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            logger.debug("Process file: {}", file.getOriginalFilename());
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File("/tmp", System.currentTimeMillis() + file.getOriginalFilename()));
        }
        return "admin/courses/success";
    }

    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    public String upload2(MultipartHttpServletRequest multiRequest) throws IOException {
        Iterator<String> filesNames = multiRequest.getFileNames();
        while (filesNames.hasNext()) {
            String fileName = filesNames.next();
            MultipartFile file = multiRequest.getFile(fileName);
            if (!file.isEmpty()) {
                logger.debug("Process file: {}", file.getOriginalFilename());
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File("/tmp", System.currentTimeMillis() + file.getOriginalFilename()));
            }
        }
        return "admin/courses/success";
    }
}
