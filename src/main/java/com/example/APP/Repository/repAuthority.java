package com.example.APP.Repository;

import com.example.APP.Model.Authority;
import com.example.APP.Utils.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface repAuthority extends JpaRepository<Authority, Integer> {
    Optional<Authority> findByName(AuthorityName name);
}
