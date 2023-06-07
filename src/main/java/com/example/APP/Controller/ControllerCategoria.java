package com.example.APP.Controller;


import com.example.APP.Interface.interfaceCategoria;
import com.example.APP.Model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class ControllerCategoria {

    @Autowired
    private interfaceCategoria service;

    @GetMapping("/categorias")
    public String listarCategorias(Model model){
        model.addAttribute("listaCategoria",service.listaCategoria());
        model.addAttribute("titulo", "Ver Categorias");
        model.addAttribute("cuerpo", "Registro de Categorias");

        return "admin/categorias";
    }
    @GetMapping("/categorias/nuevo")
    public String formularioCategoria(Model model){
        model.addAttribute("titulo","Ingresar NuevaCategoria");
        model.addAttribute("cuerpo","Registro de Categorias");
        model.addAttribute("category",new Categoria());
        return "admin/categoriaNueva";
    }

    @PostMapping("/categorias/guardar")
    public String guardarCategoria(@ModelAttribute Categoria cat){
        service.guardar(cat);
        return "redirect:/admin/categorias";
    }

    @GetMapping("/categorias/editar/{id}")
    public String editarCategoria(@PathVariable("id") int id, Model model){
        //Optional<Estudiante> est= service.editar(id);
        model.addAttribute("category",service.editar(id));
        return "admin/categoriaNueva";
    }

    @GetMapping("/categorias/eliminar/{id}")
    public String eliminarCategoria(@PathVariable("id") int id, Model model){
        service.eliminar(id);
        return "redirect:/admin/categorias";
    }

}
