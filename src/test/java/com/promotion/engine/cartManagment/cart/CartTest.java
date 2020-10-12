package com.promotion.engine.cartManagment.cart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
