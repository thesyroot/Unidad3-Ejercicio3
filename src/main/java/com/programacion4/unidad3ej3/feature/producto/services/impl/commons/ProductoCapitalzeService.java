package com.programacion4.unidad3ej3.feature.producto.services.impl.commons;

import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoCreateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.commons.IProductoCapitalizeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductoCapitalzeService implements IProductoCapitalizeService {

    @Override
    public ProductoCreateRequestDto capitalize(ProductoCreateRequestDto dto) {
        return new ProductoCreateRequestDto(
                dto.getNombre().substring(0,0).toUpperCase() + dto.getNombre().substring(1).toLowerCase(),
                dto.getCodigo(),
                dto.getDescripcion().substring(0,0).toUpperCase() + dto.getDescripcion().substring(1).toLowerCase(),
                dto.getPrecio(),
                dto.getStock(),
                dto.getIdCategoria()
        );
    }
}
