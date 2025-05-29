package com.cursosdedesarrollo.plantillas.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/mvc")
public class MVCController {

    private String message = "Mensaje";

    private final List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");
    @GetMapping()
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "mvc"; //view
    }
}
