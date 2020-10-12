package com.promotion.engine.cartManagment.cart;

import java.util.TreeMap;

public abstract class Cart {

    public static TreeMap<String, Integer> itemsAndQuantity = new TreeMap<>();

    public abstract void addItemToCart(String item, int quantity);

    public TreeMap<String, Integer> accessCart() {
        return itemsAndQuantity;
    }

    public void emptyCart() {
        itemsAndQuantity.clear();
    }
}
