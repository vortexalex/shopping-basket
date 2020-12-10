package com.vortexalex.shoppingbasket.taxes;

import com.vortexalex.shoppingbasket.ShoppingItem;
import com.vortexalex.shoppingbasket.ShoppingCategory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultTaxPolicyTest {

    private static ExemptionPolicy exemptionPolicy;

    @BeforeAll
    public static void init() {
        exemptionPolicy = new ExemptionPolicy();
    }

    @Test
    public void testPolicyAppliesNoTaxesForBook() {
        ShoppingItem item = new ShoppingItem("book", ShoppingCategory.BOOK, new BigDecimal(12.49));
        DefaultTaxPolicy taxPolicy = new DefaultTaxPolicy(exemptionPolicy);

        BigDecimal tax = taxPolicy.apply(item);

        assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void testPolicyAppliesNoTaxesForFood() {
        ShoppingItem item = new ShoppingItem("food", ShoppingCategory.FOOD, new BigDecimal(3));
        DefaultTaxPolicy taxPolicy = new DefaultTaxPolicy(exemptionPolicy);

        BigDecimal tax = taxPolicy.apply(item);

        assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void testPolicyAppliesNoTaxesForMedical() {
        ShoppingItem item = new ShoppingItem("medical", ShoppingCategory.MEDICAL, new BigDecimal(30));
        DefaultTaxPolicy taxPolicy = new DefaultTaxPolicy(exemptionPolicy);

        BigDecimal tax = taxPolicy.apply(item);

        assertEquals(new BigDecimal("0.00"), tax);
    }

    @Test
    public void testPolicyAppliesTaxesForImportedPerfume() {
        ShoppingItem item = new ShoppingItem("perfume", ShoppingCategory.OTHER, true, new BigDecimal("47.50"));
        DefaultTaxPolicy taxPolicy = new DefaultTaxPolicy(exemptionPolicy);

        BigDecimal tax = taxPolicy.apply(item);

        assertEquals(new BigDecimal("7.15"), tax);
    }

    @Test
    public void testPolicyAppliesTaxesForImportedBook() {
        ShoppingItem importBook = new ShoppingItem("importBook", ShoppingCategory.BOOK, true, new BigDecimal(10));
        DefaultTaxPolicy taxPolicy = new DefaultTaxPolicy(exemptionPolicy);

        BigDecimal tax = taxPolicy.apply(importBook);

        assertEquals(new BigDecimal("0.50"), tax);
    }


}
