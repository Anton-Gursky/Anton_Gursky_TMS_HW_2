package org.example;

public class Order {

    private String orderName;
    private int quantity;
    private int price;

    public Order() {
    }

    public String getOrderName() {
        return orderName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
