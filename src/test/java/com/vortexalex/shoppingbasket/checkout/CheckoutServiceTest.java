package com.vortexalex.shoppingbasket.checkout;

import com.sun.corba.se.spi.ior.IdentifiableFactory;
import com.vortexalex.shoppingbasket.ShoppingBasket;
import com.vortexalex.shoppingbasket.ShoppingCategory;
import com.vortexalex.shoppingbasket.ShoppingItem;
import com.vortexalex.shoppingbasket.taxes.DefaultTaxPolicy;
import com.vortexalex.shoppingbasket.taxes.ExemptionPolicy;
import com.vortexalex.shoppingbasket.taxes.TaxPolicy;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CheckoutServiceTest {

    @Test
    public void testReceiptGeneration_1() {
        ShoppingBasket basket = new ShoppingBasket();
        basket.addItem(new ShoppingItem("book", ShoppingCategory.BOOK, new BigDecimal("12.49")));
        basket.addItem(new ShoppingItem("music cd", ShoppingCategory.OTHER, new BigDecimal("14.99")));
        basket.addItem(new ShoppingItem("chocolate bar", ShoppingCategory.FOOD, new BigDecimal("0.85")));

        TaxPolicy taxPolicy = new DefaultTaxPolicy(new ExemptionPolicy());
        CheckoutService checkoutService = new CheckoutService();

        Receipt receipt = checkoutService.generateReceipt(basket, taxPolicy);

        assertEquals(3, receipt.getItems().size());
        assertEquals(new BigDecimal("1.50"), receipt.getTaxes());
        assertEquals(new BigDecimal("29.83"), receipt.getTotal());
    }

    @Test
    public void testReceiptGeneration_2() {
        ShoppingBasket basket = new ShoppingBasket();
        basket.addItem(new ShoppingItem("imported chocolate", ShoppingCategory.FOOD, true, new BigDecimal("10.00")));
        basket.addItem(new ShoppingItem("imported perfume", ShoppingCategory.OTHER, true, new BigDecimal("47.50")));

        TaxPolicy taxPolicy = new DefaultTaxPolicy(new ExemptionPolicy());
        CheckoutService checkoutService = new CheckoutService();

        Receipt receipt = checkoutService.generateReceipt(basket, taxPolicy);

        assertEquals(2, receipt.getItems().size());
        assertEquals(new BigDecimal("7.65"), receipt.getTaxes());
        assertEquals(new BigDecimal("65.15"), receipt.getTotal());
    }

    @Test
    public void testReceiptGeneration_3() {
        ShoppingBasket basket = new ShoppingBasket();
        basket.addItem(new ShoppingItem("imported perfume", ShoppingCategory.OTHER, true, new BigDecimal("27.99")));
        basket.addItem(new ShoppingItem("perfume", ShoppingCategory.OTHER, new BigDecimal("18.99")));
        basket.addItem(new ShoppingItem("headache pills", ShoppingCategory.MEDICAL, new BigDecimal("9.75")));
        basket.addItem(new ShoppingItem("box imported chocolate", ShoppingCategory.FOOD, true, new BigDecimal("11.25")));

        TaxPolicy taxPolicy = new DefaultTaxPolicy(new ExemptionPolicy());
        CheckoutService checkoutService = new CheckoutService();

        Receipt receipt = checkoutService.generateReceipt(basket, taxPolicy);

        assertEquals(4, receipt.getItems().size());
        assertEquals(new BigDecimal("6.70"), receipt.getTaxes());
        assertEquals(new BigDecimal("74.68"), receipt.getTotal());
    }


}
