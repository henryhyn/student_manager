package com.nengjun.student.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
    @RequestMapping("/hello")
    public String index(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "welcome/index";
    }

    @RequestMapping(value = "/pages/{name}/{age}", method = RequestMethod.GET)
    public String getName(@PathVariable("name") String name, @PathVariable("age") int age, ModelMap model) {
        model.addAttribute("name", name);
        model.addAttribute("age", age);
        return "welcome/name";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(@RequestParam String name, @RequestParam int number, ModelMap model) {
        model.addAttribute("name", name);
        model.addAttribute("number", number);
        return "welcome/result";
    }
}
