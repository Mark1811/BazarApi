package com.bazar.bazar.service.Impl;

import com.bazar.bazar.model.Productos;
import com.bazar.bazar.repository.ProductoRepository;
import com.bazar.bazar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public void crearProduct(Productos prod) {
        Productos nuevoProducto = productoRepository.save(prod);
    }

    @Override
    public List<Productos> listarProduct() {

        List<Productos> productos = productoRepository.findAll();
        return productos;
    }

    @Override
    public Productos editarProductId(Productos productos, Long id) {
        Productos proEditado = productoRepository.findById(id).orElseThrow();
        proEditado.setNomProduct(productos.getNomProduct());
        proEditado.setPrecio(productos.getPrecio());
        proEditado.setStock(productos.getStock());
        return proEditado;
    }

    @Override
    public void deletedProduct(Long id) {
        productoRepository.deleteById(id);
    }
}
