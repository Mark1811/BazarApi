package com.bazar.bazar.service;

import com.bazar.bazar.model.Productos;



import java.util.List;

public interface ProductService {

    public void crearProduct(Productos prod);

    public List<Productos> listarProduct();

    Productos editarProductId (Productos productos, Long id);

    public void deletedProduct (Long id);

    public Productos productMasCaro();

     public Productos productMasBarato();



}
