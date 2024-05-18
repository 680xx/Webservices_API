package com.example.webservices_api.services;

import com.example.webservices_api.entities.Product;
import com.example.webservices_api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product updatedProduct = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
            updatedProduct.setProductName(product.getProductName());
            updatedProduct.setProductPrice(product.getProductPrice());
            updatedProduct.setProductQuantity(product.getProductQuantity());
            return productRepository.save(updatedProduct);
    }


    @Override
    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }
}
