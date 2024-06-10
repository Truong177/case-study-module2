package models.user;

import models.electronic.Electronic;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private long phone;
    private Cart cart = new Cart();
    private List<Electronic> purchaseHistory = new ArrayList<>();

    public User(int id, String name, long phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
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

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Electronic> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(List<Electronic> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }
    public void addPurchase(Electronic electronic){
        this.purchaseHistory.add(new Electronic(electronic));
    }
}
