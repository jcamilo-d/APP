package com.example.APP.Interface;

import com.example.APP.Model.Categoria;
import com.example.APP.Model.Producto;

import java.util.List;
import java.util.Optional;

public interface interfaceProducto {

    public List<Producto> listaProductos();

    public void guardar(Producto prod);

    public Optional<Producto> editar(int id);

    public void eliminar(int id);

    public List<Producto> searchByFullNameQueryNative(String fullName);
    public List<Producto> searchByFullNameQueryNative2(String fullName);

}

