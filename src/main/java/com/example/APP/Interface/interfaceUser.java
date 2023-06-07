package com.example.APP.Interface;

import com.example.APP.Model.Producto;
import com.example.APP.Model.User;

import java.util.List;
import java.util.Optional;

public interface interfaceUser {
    public List<User> listaUsuarios();
    public void guardar(User user);
    public void guardarAdmin(User user);
    public Optional<User> editar(int id);
    public void eliminar(int id);
    public List<User> validarEmail (String username);
    public List<User> listaAdministradores();

}
