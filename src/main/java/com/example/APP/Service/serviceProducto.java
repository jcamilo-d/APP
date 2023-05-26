package com.example.APP.Service;

import com.example.APP.Interface.interfaceProducto;
import com.example.APP.Model.Producto;
import com.example.APP.Repository.repProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class serviceProducto implements interfaceProducto {

    @Autowired
    private repProducto repositorio;
    @Override
    public List<Producto> listaProductos() {
        return repositorio.findAll();
    }

    @Override
    public Page<Producto> findALL() {
        return null;
    }


    @Override
    public void guardar(Producto prod) {
        repositorio.save(prod);
    }

    @Override
    public Optional<Producto> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);

    }

    @Override
    public List<Producto> searchByFullNameQueryNative(String fullName) {
        return repositorio.searchByFullNameQueryNative(fullName);
    }

    @Override
    public List<Producto> searchByFullNameQueryNative2(String fullName) {
        return repositorio.searchByFullNameQueryNative2(fullName);
    }

    @Override
    public List<Producto> ultiomosJuegos() {
        return repositorio.ultiomosJuegos();
    }


}
