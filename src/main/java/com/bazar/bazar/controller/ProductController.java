package com.bazar.bazar.controller;


import com.bazar.bazar.model.Productos;
import com.bazar.bazar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @PostMapping("/crear")
    public ResponseEntity<Productos> crearProduct (@RequestBody Productos pro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.crearProduct(pro));
    }

    @GetMapping("/traer")
    @ResponseBody
    public ResponseEntity<List<Productos>> listProduct() {
        
        return ResponseEntity.ok().body(productService.listarProduct());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Productos> editarProductId(@RequestBody Productos pro, @PathVariable Long id) {
        return ResponseEntity.ok().body(productService.editarProductId(pro,id));
    }

    @DeleteMapping("eliminar/{id}")
    public ResponseEntity eliminarProducto(@PathVariable Long id) {

       return  ResponseEntity.ok().body(productService.deletedProduct(id));
    }

    @GetMapping("/mascaro")
    @ResponseBody
    public ResponseEntity<Productos> productCaros() {

        return ResponseEntity.status(HttpStatus.OK).body(productService.productMasCaro());
    }


    @GetMapping("/masbarato")
    @ResponseBody
    public ResponseEntity<Productos> productBaratos() {

        return ResponseEntity.status(HttpStatus.OK).body(productService.productMasBarato());
    }

    @GetMapping("/orMeAMa")
    @ResponseBody
    public ResponseEntity<List<Productos>> ordeMeAMay(){

        return ResponseEntity.ok().body(productService.ordenMenAMay());
    }
}
