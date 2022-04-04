package com.devinhouse.senior.mvc_aula01.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    /*@GetMapping("/hello")
    public String hello() {
        return "hello";
    }*/

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("nome", "Mundo");
        return "hello";
    }
}
