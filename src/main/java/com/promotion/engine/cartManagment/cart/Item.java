package com.promotion.engine.cartManagment.cart;

public class Item {
    public String name;
    public Integer quantity;
    public Double price;

    public Item(String Name, Integer Quantity, Double Price) {
        name = Name;
        quantity = Quantity;
        price = Price;
    }
}
