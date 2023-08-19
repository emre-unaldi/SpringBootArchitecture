package com.emreunaldi.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    // http://localhost:8000/thymeleaf1
    @GetMapping("/thymeleaf1")
    public String getThymeleaf1() {
        return "thymeleaf1";
    }

    // http://localhost:8000/thymeleaf2
    @GetMapping("/thymeleaf2")
    public String getThymeleaf2Model(Model model) {
        model.addAttribute("key_model1", "Ben Modelden Geldim - 1");
        model.addAttribute("key_model2", "Ben Modelden Geldim - 2");
        return "thymeleaf1";
    }

    // http://localhost:8000/thymeleaf3
    @GetMapping("/thymeleaf3")
    public String getThymeleaf3(Model model) {
        model.addAttribute("key_model1", "Ben Modelden Geldim - 1");
        model.addAttribute("key_model2", "Ben Modelden Geldim - 2");
        return "thymeleaf_file/thymeleaf3";
    }
}
