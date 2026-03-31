package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import com.programacion4.unidad3ej3.config.BaseResponse;
import com.programacion4.unidad3ej3.config.exceptions.BadRequestException;
import com.programacion4.unidad3ej3.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.commons.ICatalogoExistByIdService;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.commons.IProductoCapitalizeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoCreateService;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoCreateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.commons.IProductoExistByNameService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ProductoCreateService implements IProductoCreateService {

    private final IProductoExistByNameService productoExistByNameService;

    private final IProductoRepository productoRepository;

    private final IProductoCapitalizeService productoCapitalizeService;

    private final ICatalogoExistByIdService catalogoExistByIdService;

    @Override
    public ProductoResponseDto create(ProductoCreateRequestDto dto) {

        final ProductoCreateRequestDto dtoCapitalized = productoCapitalizeService.capitalize(dto);

        if (productoExistByNameService.existByName(dtoCapitalized.getNombre())) {
            throw new BadRequestException("El nombre del producto ya existe");
        }

        if (catalogoExistByIdService.existById(dtoCapitalized.getIdCategoria())) {
            throw new ResourceNotFoundException("La categoria no fue encontrada");
        }

        Producto productoAGuardar = ProductoMapper.toEntity(dtoCapitalized);
        
        Producto productoGuardado = productoRepository.save(productoAGuardar);

        return ProductoMapper.toResponseDto(productoGuardado);
    }
}
