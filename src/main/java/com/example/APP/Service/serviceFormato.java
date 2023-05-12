package com.example.APP.Service;

import com.example.APP.Interface.interfaceFormato;
import com.example.APP.Model.Formato;
import com.example.APP.Model.Producto;
import com.example.APP.Repository.repFormato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceFormato implements interfaceFormato {

    @Autowired
    private repFormato repositorio;
    @Override
    public List<Formato> listaFormatos() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Formato formato) {
        repositorio.save(formato);

    }

    @Override
    public Optional<Formato> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }
}
