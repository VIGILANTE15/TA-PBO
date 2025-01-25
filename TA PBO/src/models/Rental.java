package models;

import java.util.Date;

public class Rental {
    Product product;
    User user;
    Date rentalDate;
    public Date returnDate;
    String status;
    double totalPrice;
    double denda;

    public Rental(Product product, User user, Date rentalDate, Date returnDate, String status) {
        this.product = product;
        this.user = user;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.status = status;
        this.totalPrice = calculateTotalPrice();
        this.denda = 0.0;
    }

    private double calculateTotalPrice() {
        long duration = (returnDate.getTime() - rentalDate.getTime()) / (1000 * 60 * 60 * 24);
        return duration * product.getPrice();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getDenda() {
        return denda;
    }

    public void setDenda(double denda) {
        this.denda = denda;
    }

    @Override
    public String toString() {
        return "Product: " + product.getName() + ", User: " + user.getUsername() + ", Rental Date: " + rentalDate + ", Return Date: " + returnDate + ", Status: " + status + ", Total Price: " + totalPrice + (denda > 0 ? ", Fine: " + denda : "");
    }
}

