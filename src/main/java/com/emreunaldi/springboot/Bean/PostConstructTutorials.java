package com.emreunaldi.springboot.Bean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.logging.Logger;

@Controller
public class PostConstructTutorials {
    /*@Autowired
    Logger LOG;

    @PostConstruct
    public void init(){
        LOG.info("Log info called");
    }

    public static void main(String[] args) {
        PostConstructTutorials beanController = new PostConstructTutorials();
        System.out.println(beanController);
    }*/
}
