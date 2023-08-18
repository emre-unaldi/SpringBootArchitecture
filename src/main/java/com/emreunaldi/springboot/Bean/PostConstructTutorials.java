package com.emreunaldi.springboot.Bean;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.logging.Logger;

@Controller
public class PostConstructTutorials {
    @Autowired
    Logger LOG;

    /*
    // Parametresiz Conctructor
    // because "this.LOG" is null
    public PostConstructTutorials(){
        LOG.info("Log info called");
    }*/

    // Bean henüz başlamadığından null alıyoruz ve burada bağımlılık enjekte ediyoruz
    //Görevi: bir bean nesnesi oluşturulduğunda hemen oluşur
    @PostConstruct
    public void init(){
        LOG.info("Log info called");
    }

    public static void main(String[] args) {
        PostConstructTutorials beanController = new PostConstructTutorials();
        System.out.println(beanController);
    }
}
