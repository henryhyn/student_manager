package com.nengjun.student.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Henry on 15/9/4.
 */
@Controller
@RequestMapping("/study")
public class StudyController {
    @RequestMapping
    public String index() {
        return "study/index";
    }

    @RequestMapping("/datetime")
    public String datetime() {
        return "study/datetime";
    }

    @RequestMapping("/el")
    public String el() {
        return "study/el";
    }
}
