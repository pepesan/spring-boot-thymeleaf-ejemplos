package com.cursosdedesarrollo.plantillas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/request")
public class RequestController {
    @PostMapping()
    public String miPost(Model model, @RequestParam("id") String id){
        model.addAttribute("id",id);
        return "params";
    }
}
