package com.example.APP.Service;

import com.example.APP.Interface.interfaceCategoria;
import com.example.APP.Model.Categoria;
import com.example.APP.Repository.repCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serviceCategoria implements interfaceCategoria {

    @Autowired
    private repCategoria repositorio;
    @Override
    public List<Categoria> listaCategoria() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Categoria cat) {
        repositorio.save(cat);
    }

    @Override
    public Optional<Categoria> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }
}
