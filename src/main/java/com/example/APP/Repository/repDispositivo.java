package com.example.APP.Repository;

import com.example.APP.Model.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repDispositivo extends JpaRepository<Dispositivo, Integer> {
}
