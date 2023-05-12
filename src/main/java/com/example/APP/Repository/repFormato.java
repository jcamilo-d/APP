package com.example.APP.Repository;

import com.example.APP.Model.Formato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repFormato extends JpaRepository<Formato,Integer> {
}
