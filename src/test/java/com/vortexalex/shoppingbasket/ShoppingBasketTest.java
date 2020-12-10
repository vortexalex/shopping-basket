package com.vortexalex.shoppingbasket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShoppingBasketTest {

    @Test
    void testShoppingBasketContainsOneItem() {
        ShoppingBasket basket = new ShoppingBasket();
        basket.addItem(new ShoppingItem("book", ShoppingCategory.BOOK, new BigDecimal(12.49)));

        assertEquals(1, basket.getSize());
        ShoppingItem item = basket.getItem(0);
        assertEquals(ShoppingCategory.BOOK, item.getCategory());
        assertEquals(new BigDecimal(12.49), item.getPrice());
    }

    @Test
    void testShoppingBasketIsEmpty() {
        ShoppingBasket basket = new ShoppingBasket();

        assertEquals(0, basket.getSize());
    }
}
