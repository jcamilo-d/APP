package com.example.APP.Repository;

import com.example.APP.Model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repCategoria extends JpaRepository<Categoria, Integer>  {
}
