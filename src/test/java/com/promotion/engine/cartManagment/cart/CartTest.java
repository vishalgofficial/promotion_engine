package com.promotion.engine.cartManagment.cart;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void emptyCart_CartShouldNotAnyItem() {
        cart.addItemToCart("A", 1);
        cart.addItemToCart("B", 1);
        cart.emptyCart();
        assertTrue(cart.accessCart().isEmpty());
    }

    @Test
    void addItem_CheckCartShouldHaveUpdatedQuantityOfItem() {
        cart.emptyCart();
        cart.addItemToCart("A", 1);
        cart.addItemToCart("A", 1);
        assertEquals(2, cart.accessCart().get("A"));
    }

    @Test
    void removeItemFromCart_ShouldThrowExceptionInCaseOfMissingItem() throws Exception {
        assertThrows(Exception.class, () -> cart.removeItemFromCart("c", 1));
    }

    @Test
    void removeItemFromCart_CartShouldNotHaveRemovedItem() throws Exception {
        cart.addItemToCart("A", 1);
        cart.addItemToCart("B", 1);
        cart.removeItemFromCart("A", 1);
        assertEquals(1, cart.accessCart().size());
    }

    @Test
    void reviewItem_CartShouldCorrectItem() throws Exception {
        cart.addItemToCart("A", 1);
        cart.addItemToCart("B", 1);
        cart.removeItemFromCart("A", 1);
        cart.reviewCart();
        assertEquals(1, cart.accessCart().size());
    }

    @Test
    void calculateTotalPrice_Item_A_Quantity_5_Offer_130() throws Exception {
        cart.addItemToCart("A", 3);
        assertEquals(130.00, cart.calculateTotalPrice(cart.accessCart()));
    }

    @Test
    void calculateTotalPrice_Item_B_Quantity_2_Offer_45() throws Exception {
        cart.addItemToCart("B", 2);
        assertEquals(45.00, cart.calculateTotalPrice(cart.accessCart()));
    }
}
