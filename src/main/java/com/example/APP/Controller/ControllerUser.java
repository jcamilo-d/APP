package com.example.APP.Controller;

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
    private interfaceProducto service;


    @GetMapping("/home")
    public String paginaInicio(Model model){
        model.addAttribute("listaProductos",service.listaProductos());

    return "user/inicio";
    }

}
