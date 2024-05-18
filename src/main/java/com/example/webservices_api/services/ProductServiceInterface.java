package com.example.webservices_api.services;

import com.example.webservices_api.entities.Product;

import java.util.List;

public interface ProductServiceInterface {

    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product updateProduct(int id, Product product);
    void deleteProductById(int id);


}
