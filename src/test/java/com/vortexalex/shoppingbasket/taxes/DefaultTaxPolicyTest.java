package com.vortexalex.shoppingbasket.taxes;

import com.vortexalex.shoppingbasket.ShoppingBasket;
import com.vortexalex.shoppingbasket.ShoppingItem;
import com.vortexalex.shoppingbasket.util.ShoppingCategory;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultTaxPolicyTest {

    @Test
    public void testPolicyAppliesNoTaxesForBook() {
        ShoppingItem item = new ShoppingItem("book", ShoppingCategory.BOOK, new BigDecimal(12.49));
        DefaultTaxPolicy taxPolicy = new DefaultTaxPolicy();

        BigDecimal tax = taxPolicy.apply(item);

        assertEquals(new BigDecimal(0), tax);
    }
}
