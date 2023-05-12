package com.example.APP.Service;

import com.example.APP.Interface.interfaceDispositivo;
import com.example.APP.Model.Dispositivo;
import com.example.APP.Repository.repDispositivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceDispositivo implements interfaceDispositivo {

    @Autowired
    private repDispositivo repositorio;
    @Override
    public List<Dispositivo> listaDispositivos() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Dispositivo dispo) {
        repositorio.save(dispo);
    }

    @Override
    public Optional<Dispositivo> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }
}
