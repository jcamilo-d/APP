package com.example.APP.Repository;

import com.example.APP.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface repUser extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
}
