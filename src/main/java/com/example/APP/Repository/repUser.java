package com.example.APP.Repository;

import com.example.APP.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface repUser extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);

    @Query(value = "SELECT* FROM users u WHERE u.username = ?1", nativeQuery = true)
    List<User> validarEmail (String username);

    @Query(value = "Select u.id_usuario, u.name, u.lastname, u.username, u.password, a.name as namerol from users u join user_authority ua on u.id_usuario = ua.user_id join authorities a on a.id_authority = ua.authority_id where a.name = 'Administrador'", nativeQuery = true)
    List<User> listaAdministradores();
}
