package com.vortexalex.shoppingbasket.taxes;

import com.vortexalex.shoppingbasket.ShoppingItem;
import com.vortexalex.shoppingbasket.ShoppingCategory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ExemptionPolicyTest {

    private static ExemptionPolicy exemptionPolicy;

    @BeforeAll
    public static void init() {
        exemptionPolicy = new ExemptionPolicy();
    }

    @Test
    public void testBookIsExempt() {
        ShoppingItem book = new ShoppingItem("book", ShoppingCategory.BOOK, new BigDecimal(10));
        assertTrue(exemptionPolicy.isExempt(book));

    }

    @Test
    public void testFoodIsExempt() {
        ShoppingItem chocolate = new ShoppingItem("chocolate", ShoppingCategory.FOOD, new BigDecimal(1));
        assertTrue(exemptionPolicy.isExempt(chocolate));
    }

    @Test
    public void testMedicalIsExempt() {
        ShoppingItem pills = new ShoppingItem("pills", ShoppingCategory.MEDICAL, new BigDecimal(20));
        assertTrue(exemptionPolicy.isExempt(pills));
    }

    @Test
    public void testGoodOtherThanBookFoodAndMedicalIsNotExempt() {
        ShoppingItem movieDvd = new ShoppingItem("movieDvd", ShoppingCategory.OTHER, new BigDecimal(10));
        assertFalse(exemptionPolicy.isExempt(movieDvd));
    }
}
