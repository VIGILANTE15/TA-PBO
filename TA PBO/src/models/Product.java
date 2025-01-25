package models;

public class Product {
    private String name;
    private String brand;
    private String type;
    private String description;
    private double price;
    private int stock;

    public Product(String name, String brand, String type, String description, double price, int stock) {
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Brand: " + brand + ", Type: " + type + ", Price: " + price + ", Stock: " + stock;
    }
}