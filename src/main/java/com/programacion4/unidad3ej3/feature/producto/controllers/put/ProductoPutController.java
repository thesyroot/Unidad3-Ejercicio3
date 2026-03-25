package com.programacion4.unidad3ej3.feature.producto.controllers.put;

import com.programacion4.unidad3ej3.config.BaseResponse;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoUpdateService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoPutController {

    private final IProductoUpdateService productoUpdateService;

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<ProductoResponseDto>> replace(@PathVariable Long id, @Valid @RequestBody ProductoUpdateRequestDto dto) {
        return ResponseEntity.ok(
                BaseResponse.ok(
                        productoUpdateService.replace(id,dto),
                        "REEMPLAZADO CORRECTAMENTE"
                )
        );
    }
}
