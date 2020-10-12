package com.promotion.engine.cartManagment.cart;

import com.promotion.engine.cartManagment.cart.Cart;
import com.promotion.engine.cartManagment.cart.CartImpl;
import org.junit.jupiter.api.BeforeEach;

public class CartTest {

    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new CartImpl();
    }
}
