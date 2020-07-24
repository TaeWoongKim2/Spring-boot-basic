package com.ktnet.gethub.oss.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hi, Im ETOHO");
        return "hello";
    }

}
