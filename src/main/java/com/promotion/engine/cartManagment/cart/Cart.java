package com.promotion.engine.cartManagment.cart;

import java.util.TreeMap;

public abstract class Cart {

    public static TreeMap<String, Integer> itemsAndQuantity = new TreeMap<>();

    public abstract void addItemToCart(String item, int quantity);

    public abstract void removeItemFromCart(String item, int quantity) throws Exception;

    public abstract void reviewCart() throws Exception;

    public TreeMap<String, Integer> accessCart() {
        return itemsAndQuantity;
    }

    public void emptyCart() {
        itemsAndQuantity.clear();
    }
}
