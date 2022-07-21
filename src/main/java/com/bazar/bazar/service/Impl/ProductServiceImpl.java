package com.bazar.bazar.service.Impl;

import com.bazar.bazar.exception.BadRequestException;
import com.bazar.bazar.exception.NotFoundException;
import com.bazar.bazar.model.Productos;
import com.bazar.bazar.repository.ProductoRepository;
import com.bazar.bazar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Productos crearProduct(Productos prod) {
        if (prod.getNomproduct().isEmpty() || prod.getNomproduct() == null) {
            throw new BadRequestException("nameProduct is invalid");
        } else if ((prod.getPrecio() < 0)) {
            throw new BadRequestException("precie is invalid");
        } else if ((prod.getStock() < 0)) {
            throw new BadRequestException("stock is invalid");
        } else {
            return productoRepository.save(prod);
        }
    }


    @Override
    public List<Productos> listarProduct() {

        List<Productos> productos = productoRepository.findAll();
        if (productos.isEmpty()) {
            throw new NotFoundException("empty list");
        } else {
            return productos;
        }
    }

    @Override
    public Productos editarProductId(Productos productos, Long id) {

        Productos proEditado = productoRepository.findById(id).orElse(null);
        if (proEditado == null) {
            throw new EntityNotFoundException(id + " not found in database");
        } else {
            proEditado.setNomproduct(productos.getNomproduct());
            proEditado.setPrecio(productos.getPrecio());
            proEditado.setStock(productos.getStock());
            productoRepository.save(productos);
            return productos;
        }
    }

    @Override
    public ResponseEntity deletedProduct(Long id) {
        Productos product = productoRepository.findById(id).orElse(null);
        if (product == null) {
            throw new EntityNotFoundException(id + " not found in database");
        } else {
            productoRepository.deleteById(id);
        }
        return null;
    }

    @Override
    public Productos productMasCaro() {
        List<Productos> productos = productoRepository.findAll();
        if (productos.isEmpty() || productos == null) {
            throw new NotFoundException("empty list");
        } else {
            return productos.stream().max((a, b) -> a.getPrecio() - b.getPrecio()).get();
        }
    }


    @Override
    public Productos productMasBarato() {
        List<Productos> productos = productoRepository.findAll();
        if (productos.isEmpty() || productos == null) {
            throw new NotFoundException("empty list");
        } else {
            return productos.stream().min((a, b) -> a.getPrecio() - b.getPrecio()).get();
        }

    }

    @Override
    public List<Productos> ordenMenAMay() {
        List<Productos> productos = productoRepository.findAll();
        if (productos.isEmpty() || productos == null) {
            throw new NotFoundException("empty list");
        } else {
            Collections.sort(productos);
            return productos;
        }
    }


}
