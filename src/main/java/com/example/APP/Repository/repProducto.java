package com.example.APP.Repository;

import com.example.APP.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repProducto extends JpaRepository <Producto, Integer> {
}
