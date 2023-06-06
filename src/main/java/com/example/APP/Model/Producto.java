package com.example.APP.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.Length;

import java.sql.Blob;
import java.util.List;

@Data
@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private int id;
    @Column(length = 100, nullable = false)
    private String nombre;

    @Column(length = 1000, nullable = false)
    private String descripcion;

    private String imagen;
    @Column
    private int precio;
    @Column(length = 5)
    private int cantidad;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "producto_dispositivo", joinColumns = @JoinColumn(name = "id_producto"),
                inverseJoinColumns = @JoinColumn(name = "id_dispositivo"))
    private List<Dispositivo> dispositivo;

    @ManyToOne
    @JoinColumn(name = "formato_id")
    private Formato formato;


}
