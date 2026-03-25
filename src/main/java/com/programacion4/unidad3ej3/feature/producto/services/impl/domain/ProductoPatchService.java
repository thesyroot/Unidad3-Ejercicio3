package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProdcutoPatchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductoPatchService implements IProdcutoPatchService {

    private final IProductoRepository productoRepository;
    private final ProductoSelectByIdService productoSelectByIdService;

    @Override
    public ProductoResponseDto parcialReplace(long id, ProductoUpdateRequestDto dto) {
        Producto producto = ProductoMapper.toEntityWithId(id, productoSelectByIdService.selectById(id));

        if(dto.getNombre() != null) producto.setNombre(dto.getNombre());
        if(dto.getDescripcion() != null) producto.setDescripcion(dto.getDescripcion());
        if(dto.getCodigo() != null) producto.setCodigo(dto.getCodigo());
        if(dto.getPrecio() != null) producto.setPrecio(dto.getPrecio());
        if(dto.getStock() != null) producto.setStock(dto.getStock());

        productoRepository.save(producto);

        return productoSelectByIdService.selectById(id);
    }
}
