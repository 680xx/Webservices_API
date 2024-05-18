package com.example.webservices_api.controllers;

import com.example.webservices_api.entities.Product;
import com.example.webservices_api.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ProductService productService;

    // Get all products
    @GetMapping("/admin/products")
    @ResponseBody
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    // Create a new product
    @PostMapping("admin/addproduct")
    @ResponseBody
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }

    // Delete a product
    @DeleteMapping("admin/deleteproduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok("Product with id " +id + " was deleted");
    }

    // Update a product
    @PutMapping("admin/updateproduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }

}
