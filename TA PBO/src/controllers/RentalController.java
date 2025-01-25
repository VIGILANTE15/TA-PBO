package controllers;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import models.Product;
import models.Rental;
import models.User;

public class RentalController {
    private List<Rental> rentals;
    private static final double FINE_PER_DAY = 10000;

    public RentalController() {
        this.rentals = new ArrayList<>();
    }

    public void rentProduct(Product product, User user, Date rentalDate, Date returnDate) {
        product.setStock(product.getStock() - 1);
        rentals.add(new Rental(product, user, rentalDate, returnDate, "Active"));
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void updateRentalStatus() {
        Date today = new Date();
        for (Rental rental : rentals) {
            if (rental.getStatus().equals("Active") && today.after(rental.returnDate)) {
                rental.setStatus("Terlambat");
                long overdueDays = (today.getTime() - rental.returnDate.getTime()) / (1000 * 60 * 60 * 24);
                rental.setDenda(overdueDays * FINE_PER_DAY);
            } else if (rental.getStatus().equals("Active") && !today.after(rental.returnDate)) {
                rental.setStatus("Tepat Waktu");
            }
        }
    }
}



