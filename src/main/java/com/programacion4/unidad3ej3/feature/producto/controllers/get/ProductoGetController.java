package com.programacion4.unidad3ej3.feature.producto.controllers.get;

import com.programacion4.unidad3ej3.config.BaseResponse;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoListService;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoSelectByIdService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoGetController {

    private final IProductoListService productoListService;

    private final IProductoSelectByIdService productoSelectByIdService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<ProductoResponseDto>>> getListData(){
        return ResponseEntity.ok(
                BaseResponse.ok(
                        productoListService.getList(),
                        "SELECCIONADO EXITOSAMENTE"
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponse<ProductoResponseDto>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                BaseResponse.ok(
                        productoSelectByIdService.selectById(id),
                        "SELECCIONADO EXITOSAMENTE"
                )
        );
    }
}
