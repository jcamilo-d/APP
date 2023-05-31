package com.example.APP.Controller;

import com.example.APP.Interface.interfaceCategoria;
import com.example.APP.Interface.interfaceDispositivo;
import com.example.APP.Interface.interfaceFormato;
import com.example.APP.Interface.interfaceProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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


    @GetMapping("/login")
    public String inicioSecion(){
        return "login";
    }




    public String verHeaderLeft(Model model){
        model.addAttribute("listaCategorias",category.listaCategoria());
        model.addAttribute("listaFormatos",format.listaFormatos());
        model.addAttribute("listaDispositivos",dispositive.listaDispositivos());
        return "user/headerLeft";
    }

    @GetMapping("")
    public String verPaginaDefecto(){
        return "user/inicio";
    }
    @GetMapping("/home")
    public String paginaInicio(Model model){
        model.addAttribute("titulo","JCGAMES Home");
        model.addAttribute("listaProductos",service.listaProductos());
        model.addAttribute("lists", verHeaderLeft(model));


    return "user/inicio";
    }

    @GetMapping("/games")
    public String verJuegos(Model model){
        model.addAttribute("titulo","JCGAMES Videogames");
        model.addAttribute("pesos","COP ");
        model.addAttribute("listaProductos",service.listaProductos());
        model.addAttribute("lists", verHeaderLeft(model));
        return "user/games";
    }

    @GetMapping("/LastGames")
    public String verJuegosRecientes(Model model){
        model.addAttribute("titulo","JCGAMES Last games");
        model.addAttribute("pesos","COP ");
        try {
            model.addAttribute("lastGames",service.ultiomosJuegos());
            model.addAttribute("lists", verHeaderLeft(model));
        }catch (Exception e){
            e.printStackTrace();
        }

        return "user/lastGames";
    }

    @GetMapping("/searchByQueryNative")
    public String searchCustomerQueryNative(@RequestParam("fullNameQueryNative") String fullName, Model model) {
        try {
            model.addAttribute("icono","display:none;");
            model.addAttribute("busqueda", service.searchByFullNameQueryNative(fullName));
            model.addAttribute("pesos","COP ");
            model.addAttribute("lists", verHeaderLeft(model));
        }catch (Exception e){
            e.printStackTrace();
        }
        if (service.searchByFullNameQueryNative(fullName).isEmpty()){
            model.addAttribute("icono","display:flex;");
        }

        return "user/buscarJuegos";
    }


    @GetMapping("/searchByQueryNativeDispositive")
    public String searchCustomerQueryNativeDispositive(@RequestParam("fullNameQueryNative") String fullName, Model model){
            try {
                model.addAttribute("icono","display:none;");
                model.addAttribute("busqueda", service.searchByFullNameQueryNative2(fullName));
                model.addAttribute("pesos","COP ");
                model.addAttribute("lists", verHeaderLeft(model));
            }catch (Exception e){
                e.printStackTrace();
            }
        if (service.searchByFullNameQueryNative2(fullName).isEmpty()){
            model.addAttribute("icono","display:flex;");
        }

        return "user/buscarJuegos";
    }


}
