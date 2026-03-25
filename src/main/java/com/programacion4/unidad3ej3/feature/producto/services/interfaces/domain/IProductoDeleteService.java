package com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain;

import com.programacion4.unidad3ej3.feature.producto.models.Producto;

public interface IProductoDeleteService {

    public Producto softDelete(long id);

}
