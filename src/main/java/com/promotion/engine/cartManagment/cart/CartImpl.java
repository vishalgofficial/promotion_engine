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
        if (itemsAndQuantity.get(item) == quantity) {
            itemsAndQuantity.remove(item);
        } else if (itemsAndQuantity.get(item) > quantity) {
            itemsAndQuantity.put(item, itemsAndQuantity.get(item) - quantity);
        } else throw new Exception("Quantity for the provided iem is more than the quantity in the cart");
    }

    @Override
    public void reviewCart() throws Exception {
        if (itemsAndQuantity.isEmpty())
            throw new Exception("Your cart is empty");

        for (String item : itemsAndQuantity.keySet()) {
            Integer quantity = itemsAndQuantity.get(item);
            System.out.println("Item: " + item + " of Quantity: " + quantity);
        }
    }
}
