package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoDeleteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoDeleteService implements IProductoDeleteService {

    private final IProductoRepository productoRepository;
    private final ProductoSelectByIdService productoSelectByIdService;

    @Override
    public Producto softDelete(long id) {
        Producto producto = ProductoMapper.toEntityWithId(id, productoSelectByIdService.selectById(id));
        producto.setEstaEliminado(true);

        productoRepository.save(producto);

        return producto;
    }
}
