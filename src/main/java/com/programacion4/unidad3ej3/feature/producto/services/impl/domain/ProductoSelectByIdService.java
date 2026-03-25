package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import com.programacion4.unidad3ej3.config.exceptions.BadRequestException;
import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoSelectByIdService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoSelectByIdService implements IProductoSelectByIdService {

    private final IProductoRepository productoRepository;

    public ProductoResponseDto selectById(long id){
        final Optional<Producto> producto = productoRepository.findById(id);

        if(producto.isEmpty())  throw new ResourceNotFoundException("El identificador del producto no existe");

        return ProductoMapper.toResponseDto(producto.get());
    }

}
