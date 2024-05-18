package com.example.webservices_api.entities;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Attributes
    @Column(length = 60, nullable = false)
    private String productName;
    @Column(length = 10, nullable = false)
    private int productPrice;
    @Column(length= 5, nullable = false)
    private int productQuantity;



    // Constructors
    public Product() {
    }
    public Product(int productPrice, int productQuantity, String productName) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;

    }


    // Getters & Setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
