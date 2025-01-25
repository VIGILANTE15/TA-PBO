package models;

import java.util.List;

public class Customer extends User {
    int id;
    String name;

    public Customer(String username, String phone, String password, List<String> addresses, boolean isAdmin, int id, String name) {
        super(username, phone, password, addresses, isAdmin);
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
