package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import com.programacion4.unidad3ej3.config.BaseResponse;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoListService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ProductoListService implements IProductoListService {

    private final IProductoRepository productoRepository;

    @Override
    public List<ProductoResponseDto> getList() {
        return StreamSupport.stream(productoRepository.findAll().spliterator(), false).map(ProductoMapper::toResponseDto).toList();
    }
}
