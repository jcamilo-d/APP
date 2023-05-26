package com.example.APP.Repository;

import com.example.APP.Model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface repProducto extends JpaRepository <Producto, Integer> {

    @Query(value = "select p.id_producto, p.nombre, p.descripcion, p.imagen, p.precio, p.cantidad, p.categoria_id, p.formato_id, c.nombre AS categorias  from productos p join categoria c on p.categoria_id = c.id_categoria join formatos f on p.formato_id = f.id_formato where upper(p.nombre) like upper(concat('%', ?1,'%')) OR upper(c.nombre) like upper(concat('%', ?1,'%')) OR upper(f.nombre) like upper(concat('%', ?1,'%'))", nativeQuery = true)
    List<Producto> searchByFullNameQueryNative(String fullName);

    @Query(value = "select p.id_producto, p.nombre, p.descripcion, p.imagen, p.precio, p.cantidad, p.categoria_id, p.formato_id, d.nombre AS dispositive from productos p join producto_dispositivo pd on p.id_producto = pd.id_producto join dispositivos d on d.id_dispositivo = pd.id_dispositivo where upper(d.nombre) like upper(concat('%', ?1,'%'))", nativeQuery = true)
    List<Producto> searchByFullNameQueryNative2(String fullName);

    @Query(value = "SELECT * FROM productos ORDER BY id_producto DESC LIMIT 10;", nativeQuery = true
    )
    List<Producto> ultiomosJuegos();

}
