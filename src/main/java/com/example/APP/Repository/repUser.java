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
}
