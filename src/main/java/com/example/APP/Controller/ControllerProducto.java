package com.example.APP.Controller;

import com.example.APP.Interface.interfaceCategoria;
import com.example.APP.Interface.interfaceDispositivo;
import com.example.APP.Interface.interfaceFormato;
import com.example.APP.Interface.interfaceProducto;
import com.example.APP.Model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping
public class ControllerProducto {

    @Autowired
    private interfaceProducto service;
    @Autowired
    private interfaceCategoria category;
    @Autowired
    private interfaceFormato format;
    @Autowired
    private interfaceDispositivo dispositive;

    @GetMapping("/productos")
    public String listarProductos(Model model){
        model.addAttribute("listaProducto", service.listaProductos());
        model.addAttribute("titulo", "Videojuegos");
        model.addAttribute("cuerpo", "Juegos");

        return "productos";
    }
    @GetMapping("/productos/nuevo")
    public String formularioProducto(Model model){
        model.addAttribute("titulo","Nuevo Juego");
        model.addAttribute("cuerpo","Registro de Juegos");
        model.addAttribute("produc", new Producto());
        model.addAttribute("listaCategorias",category.listaCategoria());
        model.addAttribute("listaFormatos",format.listaFormatos());
        model.addAttribute("listaDispositivos",dispositive.listaDispositivos());
        return "ProductoNuevo";
    }

    @PostMapping("/productos/guardar")
    public String guardarProducto(@ModelAttribute Producto prod, Model model, @RequestParam("file") MultipartFile image){
        model.addAttribute("producto",prod);

        if (!image.isEmpty()){
            Path directorioImagenes =Paths.get("src//main//resources//static/img");
            String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

            try {
                byte[] bytesImg = image.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + image.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);

                prod.setImagen(image.getOriginalFilename());

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        service.guardar(prod);
        return "redirect:/productos";
    }

    @GetMapping("/productos/editar/{id}")
    public String editarProducto(@PathVariable("id") int id, Model model){
        model.addAttribute("produc",service.editar(id));
        model.addAttribute("listaCategorias",category.listaCategoria());
        model.addAttribute("listaFormatos",format.listaFormatos());
        model.addAttribute("listaDispositivos",dispositive.listaDispositivos());
        return "productoNuevo";
    }

    @GetMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable("id") int id, Model model){
        service.eliminar(id);
        return "redirect:/productos";
    }

}
