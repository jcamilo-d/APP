package com.example.APP.Controller;

import com.example.APP.Interface.interfaceUser;
import com.example.APP.Model.Formato;
import com.example.APP.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class ControllerRegistro {

    @Autowired
    private interfaceUser service;
    @GetMapping
    public String registroUsuarios(Model model){
        model.addAttribute("titulo","Registro nuevoUsuario");
        model.addAttribute("usuario",new User());
        return "registro";
    }
    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute User user) {
        service.guardar(user);
        return "redirect:/login?exito";
    }
}
