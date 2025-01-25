package view;

import java.util.List;

import models.Product;
import models.Rental;
import models.User;

public class RentalView {
    public void displayProducts(List<Product> products) {
        System.out.println("\nProducts Tersedia:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void displayUsers(List<User> users) {
        System.out.println("\nRegistered Users:");
        for (User user : users) {
            System.out.println(user);
        }
    }

    public void displayRentals(List<Rental> rentals) {
        System.out.println("\nHistory Rental:");
        for (Rental rental : rentals) {
            System.out.println(rental);
        }
    }
}
