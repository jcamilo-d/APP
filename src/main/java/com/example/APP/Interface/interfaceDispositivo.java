package com.example.APP.Interface;

import com.example.APP.Model.Dispositivo;
import com.example.APP.Model.Producto;

import java.util.List;
import java.util.Optional;

public interface interfaceDispositivo{

    public List<Dispositivo> listaDispositivos();
    public void guardar(Dispositivo dispo);
    public Optional<Dispositivo> editar(int id);
    public void eliminar(int id);
}

