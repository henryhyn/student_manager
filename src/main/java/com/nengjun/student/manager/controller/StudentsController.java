package com.nengjun.student.manager.controller;

import com.nengjun.student.manager.dao.StudentDao;
import com.nengjun.student.manager.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Henry on 15/9/3.
 */
@Controller
public class StudentsController {
    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/students")
    public String index(ModelMap model) {
        List<Student> students = studentDao.all();
        model.addAttribute("students", students);
        return "students/index";
    }

    @RequestMapping("/students/{id}")
    public String show(ModelMap model, @PathVariable("id") Long id) {
        Student student = studentDao.find(id);
        model.addAttribute(student);
        return "students/show";
    }

    @RequestMapping("/students/new")
    public String _new(ModelMap model) {
        Student student = new Student();
        model.addAttribute(student);
        return "students/form";
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String create(@ModelAttribute Student student) {
        studentDao.save(student);
        return "redirect:students/" + student.getId();
    }

    @RequestMapping("/students/{id}/edit")
    public String edit(ModelMap model, @PathVariable("id") Long id) {
        Student student = studentDao.find(id);
        model.addAttribute(student);
        return "students/form";
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        Student student = studentDao.find(id);
        studentDao.destroy(student);
        return "redirect:students/index";
    }
}
