package com.example.APP.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.Length;

import java.sql.Blob;

@Data
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String nombre;

    private String imagen;
    @Column
    private int precio;
    @Column(length = 5)
    private int cantidad;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "dispositivo_id")
    private Dispositivo dispositivo;

    @ManyToOne
    @JoinColumn(name = "formato_id")
    private Formato formato;


}