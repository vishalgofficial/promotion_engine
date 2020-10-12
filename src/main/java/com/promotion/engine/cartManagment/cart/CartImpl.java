package com.promotion.engine.cartManagment.cart;

public class CartImpl extends Cart {

    @Override
    public void addItemToCart(String item, int quantity) {
        if (!itemsAndQuantity.containsKey(item)) {
            itemsAndQuantity.put(item, quantity);
        } else {
            itemsAndQuantity.put(item, quantity + itemsAndQuantity.get(item));
        }
    }
}
