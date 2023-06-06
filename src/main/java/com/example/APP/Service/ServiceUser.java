package com.example.APP.Service;

import com.example.APP.Interface.interfaceUser;
import com.example.APP.Model.User;
import com.example.APP.Repository.repAuthority;
import com.example.APP.Repository.repUser;
import com.example.APP.Utils.AuthorityName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUser implements interfaceUser {
    @Autowired
    private repUser repositorio;
    @Autowired
    private repAuthority authorityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<User> listaUsuarios() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(User user) {
        String pass= user.getPassword();
        String passEncrip = passwordEncoder.encode(pass);
        user.setId(user.getId());
        user.setName(user.getName());
        user.setLastname(user.getLastname());
        user.setUsername(user.getUsername());
        user.setPassword(passEncrip);
        user.setAuthorities(List.of(authorityRepository.findByName(AuthorityName.Usuario).get()));
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
