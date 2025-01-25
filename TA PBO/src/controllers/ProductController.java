package controllers;

import java.util.List;
import java.util.ArrayList;

import models.Product;

public class ProductController {
    private List<Product> products;

    public ProductController() {
        this.products = new ArrayList<>();
    }

    public void addProduct(String name, String brand, String type, String description, double price, int stock) {
        products.add(new Product(name, brand, type, description, price, stock));
    }

    public List<Product> getProducts() {
        return products;
    }
}