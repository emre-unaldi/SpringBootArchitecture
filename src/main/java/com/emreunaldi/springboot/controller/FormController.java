package com.emreunaldi.springboot.controller;

import com.emreunaldi.springboot.dto.TeacherDTO;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@Log4j2
public class FormController {
    //    Form
    //    @GetMapping
    //    @PostMapping
    //    @PutMapping
    //    @DeleteMapping

    // GET method
    // http://localhost/8000/form
    @GetMapping("/form")
    public String getForm(Model model) {
        model.addAttribute("cv_teacher", new TeacherDTO());

        return "post_form/formValidation";
    }

    // http://localhost/8000/form
    @PostMapping("/form")
    public String addForm(@Valid @ModelAttribute("cv_teacher") TeacherDTO teacherDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("LOG -> Hata var ...");
            System.err.println("Hata var ...");
            return "post_form/formValidation";
        }

        log.info("Success !" + teacherDTO);
        // burada  database kaydetme yapılabilir
        // burada dosyaya yazdırılma yapılabilir

        return "post_form/success";
    }

}
