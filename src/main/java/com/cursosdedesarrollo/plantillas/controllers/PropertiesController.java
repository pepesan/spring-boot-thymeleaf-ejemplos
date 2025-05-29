package com.cursosdedesarrollo.plantillas.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/properties")
public class PropertiesController {
    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    @GetMapping()
    public String main(Model model) {

        model.addAttribute("message", message);

        return "mvc"; //view
    }
}
