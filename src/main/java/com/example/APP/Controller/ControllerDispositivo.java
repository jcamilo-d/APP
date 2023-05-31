package com.example.APP.Controller;

import com.example.APP.Interface.interfaceDispositivo;
import com.example.APP.Model.Dispositivo;
import com.example.APP.Model.Formato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("")
public class ControllerDispositivo {
    @Autowired
    private interfaceDispositivo service;

    @GetMapping("/dispositivos")
    public String  listarDispositivos(Model model){
        model.addAttribute("titulo","Ver Dispositivos");
        model.addAttribute("cuerpo","Dispositivos para Videojuegos");
        model.addAttribute("listaDispositivo",service.listaDispositivos());
        return "admin/dispositivos";
    }

    @GetMapping("/dispositivos/nuevo")
    public String formularioDispositivo(Model model){
        model.addAttribute("titulo","Ingresar NuevoDispositivo");
        model.addAttribute("cuerpo","Registro de Dispositivo");
        model.addAttribute("dispositive",new Dispositivo());
        return "admin/dispositivoNuevo";
    }

    @PostMapping("/dispositivos/guardar")
    public String guardarDispositivo(@ModelAttribute Dispositivo dispositivo){
        service.guardar(dispositivo);
        return "redirect:/dispositivos";
    }

    @GetMapping("/dispositivos/editar/{id}")
    public String editarDispositivo(@PathVariable("id") int id, Model model){
        model.addAttribute("dispositive",service.editar(id));
        return "admin/dispositivoNuevo";
    }

    @GetMapping("/dispositivos/eliminar/{id}")
    public String eliminarDispositivo(@PathVariable("id") int id, Model model){
        service.eliminar(id);
        return "redirect:/formatos";
    }
}
