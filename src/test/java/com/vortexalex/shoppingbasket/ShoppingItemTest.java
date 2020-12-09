package com.vortexalex.shoppingbasket;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingItemTest {

    @Test
    void testItemDescriptionAndPrice(){
        ShoppingItem item = new ShoppingItem("book", new BigDecimal(10));
        assertEquals("book", item.getDescription());
        assertEquals(new BigDecimal(10), item.getPrice());
    }
}
