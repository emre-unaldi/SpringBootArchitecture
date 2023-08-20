package com.emreunaldi.springboot.controller;

import com.emreunaldi.springboot.dto.ProductDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    // option : root {}
    // http://localhost:8000/
    // http://localhost:8000/index
    @GetMapping({"/", "index"})
    public String index() {
        return "index";
    }

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

    // http://localhost:8000/thymeleaf4
    @GetMapping("/thymeleaf4")
    public String getThymeleaf4(Model model) {
        model.addAttribute("key_model1", "Ben Modelden Geldim - 1");
        return "thymeleaf4";
    }

    // http://localhost:8000/thymeleaf5
    @GetMapping("/thymeleaf5")
    public String getThymeleaf5Object(Model model) {
        model.addAttribute("key_model1", "Text");

        ProductDTO productDTO;
        productDTO = ProductDTO
                .builder()
                .productId(0L)
                .productName("Ürün Adı")
                .productPrice(2000)
                .build();

        model.addAttribute("key_model2", productDTO);

        return "thymeleaf5";
    }

    // http://localhost:8000/thymeleaf6
    @GetMapping("/thymeleaf6")
    public String getThymeleaf6ObjectList(Model model) {
        model.addAttribute("key_model1", "text");
        List<ProductDTO> productList = new ArrayList<>();

        productList.add(ProductDTO.builder().productId(1L).productName("Ürün Adı 1").productPrice(1000).build());
        productList.add(ProductDTO.builder().productId(2L).productName("Ürün Adı 2").productPrice(2000).build());
        productList.add(ProductDTO.builder().productId(3L).productName("Ürün Adı 3").productPrice(3000).build());
        productList.add(ProductDTO.builder().productId(4L).productName("Ürün Adı 4").productPrice(4000).build());
        productList.add(ProductDTO.builder().productId(5L).productName("Ürün Adı 5").productPrice(5000).build());

        model.addAttribute("productList", productList);

        return "thymeleaf6";
    }

    // @PathVariable
    // http://localhost:8000/thymeleaf7/{id}
    // http://localhost:8000/thymeleaf7/
    @GetMapping({"/thymeleaf7/{id}", "/thymeleaf7"})
    public String getThymeleaf7Object(Model model, @PathVariable(name = "id", required = false) Long id) {
        if (id != null) {
            model.addAttribute("key_model1", "id : " + id);
        } else {
            model.addAttribute("key_model1", "id bulunamadı");
        }

        return "thymeleaf7";
    }

    // @RequestParam
    // http://localhost:8000/thymeleaf8?id=4&name=Emre
    @GetMapping("/thymeleaf8")
    public String getThymeleaf8Object(Model model,
                                      @RequestParam(name = "id", required = false, defaultValue = "0") Long id,
                                      @RequestParam(name = "name") String name
    ) {
        if (id != null) {
            model.addAttribute("key_model1", "id : " + id + " Ad : " + name);
        } else {
            model.addAttribute("key_model1", "id bulunamadı");
        }

        return "thymeleaf8";
    }
}
