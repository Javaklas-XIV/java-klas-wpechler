package org.example.Labs.h7_webshop.controller;

import org.example.Labs.h7_webshop.model.Product;
import org.example.Labs.h7_webshop.repository.ProductRepo;

public class ProductController {
    private ProductRepo productRepo = new ProductRepo();
    public Product findProductBy(String name) {
        return productRepo.findByName(name).stream().findFirst().orElse(null);
    }
    public void createProduct(String name, String price) {
        productRepo.createProduct(name, price);
    }
}
