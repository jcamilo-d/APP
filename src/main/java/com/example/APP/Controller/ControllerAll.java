package com.example.APP.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerAll {

@GetMapping("/")
    public String verPaginaInicio(Model model){
        model.addAttribute("titulo","VideoJuegos");
        model.addAttribute("cuerpo","VideoGame Store");
        return "index";
    }

    @GetMapping("/home")
    public String paginaInicio(Model model){
    return "inicio";
    }

}
