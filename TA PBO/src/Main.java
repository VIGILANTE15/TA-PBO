import java.util.*;

import models.User;
import models.Product;
import controllers.ProductController;
import controllers.RentalController;
import controllers.UserController;
import view.RentalView;

public class Main {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        UserController userController = new UserController();
        RentalController rentalController = new RentalController();
        RentalView rentalView = new RentalView();

        Scanner scanner = new Scanner(System.in);

        // Add default admin
        userController.registerUser("admin", "0000000000", "admin123", new ArrayList<>(), true);
        userController.registerUser("customer","111111", "customer123", new ArrayList<>(), false);

        productController.addProduct("Sepatu","eger","---","denda 10.000 perhari",30000,5);
        productController.addProduct("Tenda","speeds","double layer, 1 - 3 orang","denda 10.000 perhari",40000,6);
        productController.addProduct("carrier","eiger", "45 liter", "denda 10000 perhari", 20000,8);

        System.out.println("Selamat datang di Rental Management System");
        User loggedInUser = null;

        while (loggedInUser == null) {
            try {
                System.out.print("Enter username: ");
                String username = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();

                loggedInUser = userController.loginUser(username, password);
            } catch (Exception e) {
                System.out.println(e.getMessage() + " Silahkan coba lagi.");
            }
        }

        if (loggedInUser.isAdmin()) {
            int choice;
            do {
                System.out.println("\nAdmin Menu");
                System.out.println("1. Tambah Product");
                System.out.println("2. Lihat Product");
                System.out.println("3. lihat Rental");
                System.out.println("4. Update Rental Status");
                System.out.println("5. Register Customer");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter product name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter product brand: ");
                        String brand = scanner.nextLine();
                        System.out.print("Enter product type: ");
                        String type = scanner.nextLine();
                        System.out.print("Enter product description: ");
                        String description = scanner.nextLine();
                        System.out.print("Enter product price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter product stock: ");
                        int stock = scanner.nextInt();

                        productController.addProduct(name, brand, type, description, price, stock);
                        System.out.println("Product added successfully.");
                        break;
                    case 2:
                        rentalView.displayProducts(productController.getProducts());
                        break;
                    case 3:
                        rentalView.displayRentals(rentalController.getRentals());
                        break;
                    case 4:
                        rentalController.updateRentalStatus();
                        System.out.println("Rental statuses updated successfully.");
                        break;
                    case 5:
                        System.out.print("Enter product name: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter product brand: ");
                        String phone = scanner.nextLine();
                        System.out.print("Enter product type: ");
                        String password = scanner.nextLine();
                        System.out.print("Enter product description: ");
                        List<String> addresses = Collections.singletonList(scanner.nextLine());
                        userController.registerUser(username, phone, password, addresses, false);
                        break;
                    case 6:
                        System.out.print("Keluar");
                    default:
                        System.out.println("Harap memasukkan angka dengan benar.");
                }
            } while (choice != 6);
        } else {
            int choice;
            do {
                System.out.println("\nCustomer Menu");
                System.out.println("1. Lihat Product");
                System.out.println("2. Sewa Product");
                System.out.println("3. Lihat Rental");
                System.out.println("4. Exit");
                System.out.print("Silahkan pilih pilihan: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        rentalView.displayProducts(productController.getProducts());
                        break;
                    case 2:
                        System.out.print("Masukkan Nama Product yang mau disewa");
                        String productName = scanner.nextLine();
                        Product product = productController.getProducts().stream().filter(p -> p.getName().equals(productName) && p.isAvailable()).findFirst().orElse(null);

                        if (product == null) {
                            System.out.println("Product tidak tersedia di Stock");
                            break;
                        }

                        System.out.print("Masukkan Jumlah Hari yang akan disewa: ");
                        int days = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        Calendar calendar = Calendar.getInstance();
                        Date rentalDate = calendar.getTime();
                        calendar.add(Calendar.DAY_OF_MONTH, days);
                        Date returnDate = calendar.getTime();

                        rentalController.rentProduct(product, loggedInUser, rentalDate, returnDate);
                        System.out.println("Berhasil Menyewa Barang");
                        break;
                    case 3:
                        rentalController.updateRentalStatus();
                        rentalView.displayRentals(rentalController.getRentals());
                        break;
                    case 4:
                        System.out.println("Keluar");
                        loggedInUser = null;
                    default:
                        System.out.println("Harap Masukkan angka dengan benar");
                }
            } while (choice != 5);
        }

        scanner.close();
    }
}