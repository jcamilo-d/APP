package com.example.APP.Controller;

import com.example.APP.Interface.interfaceFormato;
import com.example.APP.Model.Categoria;
import com.example.APP.Model.Formato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class ControllerFormato{

    @Autowired
    private interfaceFormato service;
    @GetMapping("/formatos")
    public String  listarFormatos(Model model){
        model.addAttribute("titulo","Ver Formatos");
        model.addAttribute("cuerpo","Formatos de Videojuegos");
        model.addAttribute("listaFormatos",service.listaFormatos());
        return "admin/formatos";
    }

    @GetMapping("/formatos/nuevo")
    public String formularioFormato(Model model){
        model.addAttribute("titulo","Ingresar NuevoFormato");
        model.addAttribute("cuerpo","Registro de Formatos");
        model.addAttribute("format",new Formato());
        return "admin/formatoNuevo";
    }

    @PostMapping("/formatos/guardar")
    public String guardarFormato(@ModelAttribute Formato formato){
        service.guardar(formato);
        return "redirect:/formatos";
    }

    @GetMapping("/formatos/editar/{id}")
    public String editarFormato(@PathVariable("id") int id, Model model){
        model.addAttribute("format",service.editar(id));
        return "admin/formatoNuevo";
    }

    @GetMapping("/formatos/eliminar/{id}")
    public String eliminarFormato(@PathVariable("id") int id, Model model){
        service.eliminar(id);
        return "redirect:/formatos";
    }

}
