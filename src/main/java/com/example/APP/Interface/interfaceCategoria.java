package com.example.APP.Interface;

import com.example.APP.Model.Categoria;

import java.util.List;
import java.util.Optional;

public interface interfaceCategoria {
    public List<Categoria> listaCategoria();
    public void guardar(Categoria cat);
    public Optional<Categoria> editar(int id);
    public void eliminar(int id);

}
