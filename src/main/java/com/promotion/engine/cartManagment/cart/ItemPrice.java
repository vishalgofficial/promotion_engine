package com.promotion.engine.cartManagment.cart;

public enum ItemPrice {

    A(50.0),
    B(30.0),
    C(20.0),
    D(15.0);

    double price;

    ItemPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
