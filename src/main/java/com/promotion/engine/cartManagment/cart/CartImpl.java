package com.promotion.engine.cartManagment.cart;

public class CartImpl extends Cart {

    @Override
    public void addItemToCart(String item, int quantity) {
        itemsAndQuantity.put(item, quantity);
    }
}
