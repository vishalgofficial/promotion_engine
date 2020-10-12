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

    @Override
    public void removeItemFromCart(String item, int quantity) throws Exception {
        if (!itemsAndQuantity.containsKey(item)) throw new Exception("No such item in your cart");
    }
}
