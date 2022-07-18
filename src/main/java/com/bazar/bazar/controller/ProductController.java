package com.bazar.bazar.controller;


import com.bazar.bazar.model.Productos;
import com.bazar.bazar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/crear")
    public void crearProduct(@RequestBody Productos pro) {
        productService.crearProduct(pro);
    }

    @GetMapping("/traer")
    @ResponseBody
    public List<Productos> listProduct() {
        return productService.listarProduct();
    }

    @PutMapping("/edit/{id}")
    public Productos editarProductId(@RequestBody Productos pro, @PathVariable Long id) {
        return productService.editarProductId(pro, id);
    }

    @DeleteMapping("eliminar/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productService.deletedProduct(id);
    }

    @GetMapping("/mascaro")
    @ResponseBody
    public Productos productCaros() {

        return productService.productMasCaro();
    }
}
