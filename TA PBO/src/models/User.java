package models;

import java.util.List;

public class User {
    String username;
    String phone;
    String password;
    List<String> addresses;
    boolean isAdmin;

    public User(String username, String phone, String password, List<String> addresses, boolean isAdmin) {
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.addresses = addresses;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public List<String> getAddresses() {
        return addresses;
    }

    @Override
    public String toString() {
        return "Username: " + username + ", Phone: " + phone + ", Addresses: " + addresses;
    }
}