package com.example.APP.Interface;

import com.example.APP.Model.Formato;
import com.example.APP.Model.Producto;

import java.util.List;
import java.util.Optional;

public interface interfaceFormato {

    public List<Formato> listaFormatos();
    public void guardar(Formato formato);
    public Optional<Formato> editar(int id);
    public void eliminar(int id);
}

