package com.emreunaldi.springboot.controller;

import com.emreunaldi.springboot.Bean.BeanConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BeanController {
    @Autowired
    BeanConfig beanConfig;

    @GetMapping("/bean/beanDto")
    @ResponseBody
    public String getBeanDto() {
        return beanConfig.beanDTO().toString();
    }
}
