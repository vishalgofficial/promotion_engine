package com.promotion.engine.cartManagment.cart;

public enum Offers {

    A {
        @Override
        public Item getOffer() {
            return new Item("A", 3, 130.0);
        }
    },

    B {
        @Override
        public Item getOffer() {
            return new Item("B", 2, 45.0);
        }
    };

    public abstract Item getOffer();

}
