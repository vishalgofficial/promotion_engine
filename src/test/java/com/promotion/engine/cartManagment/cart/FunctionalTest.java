package com.promotion.engine.cartManagment.cart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionalTest {
    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new CartImpl();
    }

    @Test
    void scenarioFirst() throws Exception {
        cart.addItemToCart("A", 1);
        cart.addItemToCart("B", 1);
        cart.addItemToCart("C", 1);
        cart.reviewCart();
        assertEquals(100.00, cart.calculateTotalPrice(cart.accessCart()));
        System.out.println(cart.calculateTotalPrice(cart.accessCart()));
    }
}
