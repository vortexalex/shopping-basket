package com.vortexalex.shoppingbasket;

import com.vortexalex.shoppingbasket.util.ShoppingCategory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingItemTest {

    @Test
    void testRightDescriptionCategoryAndPrice() {
        ShoppingItem item = new ShoppingItem("book", ShoppingCategory.BOOK, new BigDecimal(10));
        assertEquals("book", item.getDescription());
        assertEquals(ShoppingCategory.BOOK, item.getCategory());
        assertEquals(new BigDecimal(10), item.getPrice());
    }
}
