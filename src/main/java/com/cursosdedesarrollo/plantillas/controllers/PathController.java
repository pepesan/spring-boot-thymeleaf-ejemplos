package com.cursosdedesarrollo.plantillas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/path")
public class PathController {

    @GetMapping("/{id}")
    public String getPath(@PathVariable("id") String id, Model model){
        model.addAttribute("id",id);
        return "params";
    }
}
