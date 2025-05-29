package com.cursosdedesarrollo.plantillas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/form")
public class FormController {
    @GetMapping()
    public String miGet(){
        return "form";
    }

    @PostMapping()
    public String miPost(Model model, @RequestParam("id") String id){
        model.addAttribute("id",id);
        return "params";
    }
}
