package com.programacion4.unidad3ej3.feature.producto.repositories;

import com.programacion4.unidad3ej3.feature.producto.models.Catalogo;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ICatalogoRepository extends CrudRepository<Catalogo, Long> {
}