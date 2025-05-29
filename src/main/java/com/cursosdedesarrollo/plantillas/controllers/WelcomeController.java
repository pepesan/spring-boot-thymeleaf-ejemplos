package com.cursosdedesarrollo.plantillas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String welcome(Model model) {
        // Puedes pasar atributos desde aquí:
        model.addAttribute("usuario", "Invitado");
        return "welcome";
    }
}
