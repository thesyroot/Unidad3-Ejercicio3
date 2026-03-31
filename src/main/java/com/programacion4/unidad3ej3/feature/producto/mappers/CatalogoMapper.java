package com.programacion4.unidad3ej3.feature.producto.mappers;

import com.programacion4.unidad3ej3.feature.producto.dtos.response.CatalogoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.models.Catalogo;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;

public class CatalogoMapper {

    public static CatalogoResponseDto toResponseDto(Catalogo catalogo) {
        CatalogoResponseDto dto = new CatalogoResponseDto();

        dto.setName(catalogo.getName());

        return dto;
    }

}
