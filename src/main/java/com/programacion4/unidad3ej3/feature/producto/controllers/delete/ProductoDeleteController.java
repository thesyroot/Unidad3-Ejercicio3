package com.programacion4.unidad3ej3.feature.producto.controllers.delete;

import com.programacion4.unidad3ej3.config.BaseResponse;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoDeleteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoDeleteController {

    private final IProductoDeleteService productoDeleteService;

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Producto>> replace(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                BaseResponse.ok(
                        productoDeleteService.softDelete(id),
                        "ELIMINADO CORRECTAMENTE"
                )
        );
    }

}
