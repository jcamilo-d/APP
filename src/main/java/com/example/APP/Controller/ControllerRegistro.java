package com.example.APP.Controller;

import com.example.APP.Interface.interfaceUser;
import com.example.APP.Model.Formato;
import com.example.APP.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String registrarCuentaDeUsuario(@RequestParam("username") String username, @ModelAttribute User user,Model model) {
        if (service.validarEmail(username).isEmpty()){
        service.guardar(user);
        return "redirect:/registro?alert=succes";
        }else {
            model.addAttribute("alerta","Este email ya esta en uso");
            System.out.println("Este email ya esta en uso");
        return "redirect:/registro?alert=exist";
        }
    }
}
