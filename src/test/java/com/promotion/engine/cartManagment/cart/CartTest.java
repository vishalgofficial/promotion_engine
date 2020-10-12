package com.promotion.engine.cartManagment.cart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartTest {

    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new CartImpl();
    }

    @Test
    void addItem_CartShouldContainAddedItem() {
        cart.addItemToCart("A", 1);
        assertEquals(1, cart.accessCart().size());
    }

    @Test
    void addItem_CartShouldHaveItem_A() {
        cart.addItemToCart("A", 1);
        assertTrue(cart.accessCart().containsKey("A"));
    }
}
