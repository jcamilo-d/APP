package com.example.APP.Controller;

import com.example.APP.Interface.interfaceCategoria;
import com.example.APP.Interface.interfaceDispositivo;
import com.example.APP.Interface.interfaceFormato;
import com.example.APP.Interface.interfaceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class ControllerUser {

    @Autowired
    private interfaceCategoria category;
    @Autowired
    private interfaceFormato format;
    @Autowired
    private interfaceDispositivo dispositive;
    @Autowired
    private interfaceProducto service;


    @GetMapping("/home")
    public String paginaInicio(Model model){
        model.addAttribute("titulo","JCGAMES HOME");
        model.addAttribute("listaProductos",service.listaProductos());
        model.addAttribute("listaCategorias",category.listaCategoria());
        model.addAttribute("listaFormatos",format.listaFormatos());
        model.addAttribute("listaDispositivos",dispositive.listaDispositivos());

    return "user/inicio";
    }

    @GetMapping("/games")
    public String verJuegos(Model model){
        model.addAttribute("titulo","JCGAMES VIDEOGAMES");
        model.addAttribute("pesos","COP ");
        model.addAttribute("listaProductos",service.listaProductos());
        model.addAttribute("listaCategorias",category.listaCategoria());
        model.addAttribute("listaFormatos",format.listaFormatos());
        model.addAttribute("listaDispositivos",dispositive.listaDispositivos());
        return "user/games";
    }

}
