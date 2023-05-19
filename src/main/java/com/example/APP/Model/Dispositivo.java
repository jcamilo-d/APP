package com.example.APP.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "dispositivos")
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dispositivo")
    private int id;
    @Column(length = 50, nullable = false)
    private String nombre;

}
