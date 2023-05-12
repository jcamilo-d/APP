package com.example.APP.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "formatos")
public class Formato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 30, nullable = false)
    private String nombre;
}
