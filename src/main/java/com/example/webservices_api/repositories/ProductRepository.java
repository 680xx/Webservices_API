package com.example.webservices_api.repositories;

import com.example.webservices_api.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
