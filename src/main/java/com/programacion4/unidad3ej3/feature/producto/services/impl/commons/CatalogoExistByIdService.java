package com.programacion4.unidad3ej3.feature.producto.services.impl.commons;

import com.programacion4.unidad3ej3.feature.producto.repositories.ICatalogoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.commons.ICatalogoExistByIdService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CatalogoExistByIdService implements ICatalogoExistByIdService {

    private final ICatalogoRepository catalogoRepository;

    @Override
    public boolean existById(long id) {
        return catalogoRepository.existsById(id);
    }

}
