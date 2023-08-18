package com.emreunaldi.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Log4j2
@Builder
public class BeanDTO {
    private Long id;
    private String beanName;
    private String beanData;

    public void initialBeanMethod() {
        log.info("I'm in before the bean starts");
        System.out.println("Method to run before Bean starts");
    }

    public void destroyBeanMethod() {
        log.info("I'm in after the bean is over");
        System.out.println("Method to run after the bean is finished");
    }
}
