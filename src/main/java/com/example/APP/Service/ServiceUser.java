package com.example.APP.Service;

import com.example.APP.Interface.interfaceUser;
import com.example.APP.Model.User;
import com.example.APP.Repository.repUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUser implements interfaceUser {
    @Autowired
    private repUser repositorio;
    @Override
    public List<User> listaUsuarios() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(User user) {
        repositorio.save(user);
    }

    @Override
    public Optional<User> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<User> validarEmail(String username) {
        return repositorio.validarEmail(username);
    }
}
