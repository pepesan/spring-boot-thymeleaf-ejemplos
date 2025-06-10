package com.cursosdedesarrollo.plantillas.controllers;

import com.cursosdedesarrollo.plantillas.domain.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/formulario")
public class FormularioController {
    @GetMapping()
    public String lista(Model modelo) {
        // inicializamos el objeto
        Persona persona= new Persona("Laura","Merino",22);
        // lo pasamos a la vista
        modelo.addAttribute("persona", persona);
        // seleccionamos la plantilla a presentar
        return "formulario";
    }
    @PostMapping("/create")
    public ModelAndView createUser(@Valid Persona persona, BindingResult result) {
        ModelAndView model = new ModelAndView();
        model.addObject("persona", persona);
        model.setViewName(result.hasErrors() ? "formulario" : "personaReady");
        return model;
    }
}
