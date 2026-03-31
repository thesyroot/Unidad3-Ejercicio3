package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoCreateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.ICatalogoRepository;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.commons.ICatalogoExistByIdService;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoUpdateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductoUpdateService implements IProductoUpdateService {

    private final IProductoRepository productoRepository;
    private final ProductoSelectByIdService productoSelectByIdService;
    private final ICatalogoExistByIdService catalogoExistByIdService;
    private final ICatalogoRepository catalogoRepository;

    @Override
    public ProductoResponseDto replace(long id, ProductoUpdateRequestDto dto) {
        Producto producto = ProductoMapper.toEntityWithId(id, dto);

        if(catalogoExistByIdService.existById(dto.getCategoria())) {
            producto.setCatalogo(catalogoRepository.findById(dto.getCategoria()).get());
        }else{
            throw new ResourceNotFoundException("La categoria no fue encontrada");
        }

        productoRepository.save(producto);

        return productoSelectByIdService.selectById(id);
    }
}
