package com.bazar.bazar.service;

import com.bazar.bazar.model.Productos;
import org.springframework.http.ResponseEntity;


import java.util.List;

public interface ProductService {

    public Productos crearProduct (Productos prod);

    List<Productos> listarProduct();

    Productos editarProductId(Productos productos, Long id);

    public ResponseEntity deletedProduct(Long id);

    public Productos productMasCaro();

    public Productos productMasBarato();

    public List<Productos> ordenMenAMay();
}
