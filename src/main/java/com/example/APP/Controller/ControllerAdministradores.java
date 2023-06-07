package com.example.APP.Controller;

import com.example.APP.Interface.interfaceUser;
import com.example.APP.Model.Formato;
import com.example.APP.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class ControllerAdministradores {

    @Autowired
    private interfaceUser service;

    @GetMapping("/administradores")
    public String verAdministradores(Model model){
        model.addAttribute("titulo","ver Administradores");
        model.addAttribute("cuerpo","Administradores");
        try {
        model.addAttribute("listaAdmins",service.listaAdministradores());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "admin/administradores";
    }

    @GetMapping("/administradores/nuevo")
    public String formularioAdministrador(Model model){
        model.addAttribute("titulo","Ingresar NuevoAdministrador");
        model.addAttribute("cuerpo","Registro de Administrador");
        model.addAttribute("admin",new User());
        return "admin/administradoresNuevo";
    }
    @GetMapping("/administradores/editarAdmin")
    public String FormulariEditarAdmin(Model model){
        model.addAttribute("titulo","Editar Administrador");
        model.addAttribute("cuerpo","Editar Administrador");
        model.addAttribute("admin",new User());
        return "admin/administradoresEditar";
    }
    @PostMapping("/administradores/editarAdmin")
    public String editarAdmin(@ModelAttribute User user){
        service.guardarAdmin(user);
        return "redirect:/admin/administradores";
    }

    @PostMapping("/administradores/guardar")
    public String guardarAdministrador(@RequestParam("username") String username, @ModelAttribute User user,Model model) {
        if (service.validarEmail(username).isEmpty()){
            service.guardarAdmin(user);
            return "redirect:/admin/administradores?succes";
        }else {
            return "redirect:/admin/administradores/nuevo?exist";
        }
    }
    @GetMapping("/administradores/editar/{id}")
    public String editarAdministrador(@PathVariable("id") int id, Model model){
        model.addAttribute("admin",service.editar(id));
        return "admin/administradoresEditar";
    }

    @GetMapping("/administradores/eliminar/{id}")
    public String eliminarAdministrador(@PathVariable("id") int id, Model model){
        service.eliminar(id);
        return "redirect:/admin/administradores";
    }

}
