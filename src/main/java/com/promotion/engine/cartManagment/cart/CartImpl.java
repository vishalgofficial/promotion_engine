package com.promotion.engine.cartManagment.cart;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;

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

    @Override
    public double calculateTotalPrice(TreeMap<String, Integer> itemsListMap) {
        Double total = 0.0;
        Set<String> keys = itemsListMap.keySet();
        for (String item : keys) {
            Integer quantity = itemsListMap.get(item);
            double itemPrice = ItemPrice.valueOf(item).getPrice();
            if (Arrays.stream(Offers.values()).anyMatch(o -> o.name().equalsIgnoreCase(item))) {
                Item itemOffer = Offers.valueOf(item).getOffer();
                if (itemOffer.quantity < quantity) {
                    total = total + ((quantity % itemOffer.quantity) * itemPrice + (quantity / itemOffer.quantity) * itemOffer.price);
                } else if (itemOffer.quantity.equals(quantity)) {
                    total += itemOffer.price;
                } else {
                    total += (quantity) * itemPrice;
                }
            } else {
                total += (quantity) * itemPrice;
            }
        }
        return total;
    }
}
