package com.vortexalex.shoppingbasket;

import com.vortexalex.shoppingbasket.checkout.CheckoutService;
import com.vortexalex.shoppingbasket.printing.ConsolePrintService;
import com.vortexalex.shoppingbasket.printing.PrintService;
import com.vortexalex.shoppingbasket.taxes.DefaultTaxPolicy;
import com.vortexalex.shoppingbasket.taxes.ExemptionPolicy;
import com.vortexalex.shoppingbasket.taxes.TaxPolicy;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sun.security.provider.SHA;

import java.math.BigDecimal;

public class ApplicationTest {

    private static TaxPolicy taxPolicy;
    private static ExemptionPolicy exemptionPolicy;

    private static CheckoutService checkoutService;
    private static PrintService printService;

    @BeforeAll
    public static void init() {
        exemptionPolicy = new ExemptionPolicy();
        taxPolicy = new DefaultTaxPolicy(exemptionPolicy);

        checkoutService = new CheckoutService();
        printService = new ConsolePrintService();
    }

    @Test
    public void test_1() {
        ShoppingBasket basket = new ShoppingBasket();
        basket.addItem(new ShoppingItem("book", ShoppingCategory.BOOK, new BigDecimal("12.49")));
        basket.addItem(new ShoppingItem("music CD", ShoppingCategory.OTHER, new BigDecimal("14.99")));
        basket.addItem(new ShoppingItem("chocolate bar", ShoppingCategory.FOOD, new BigDecimal("0.85")));

        Receipt receipt = checkoutService.generateReceipt(basket, taxPolicy);
        printService.print(receipt);
    }

    @Test
    public void test_2() {
        ShoppingBasket basket = new ShoppingBasket();
        basket.addItem(new ShoppingItem("imported box of chocolates", ShoppingCategory.FOOD, true, new BigDecimal("10.00")));
        basket.addItem(new ShoppingItem("imported bottle of perfume", ShoppingCategory.OTHER, true, new BigDecimal("47.50")));

        Receipt receipt = checkoutService.generateReceipt(basket, taxPolicy);
        printService.print(receipt);
    }

    @Test
    public void test_3() {
        ShoppingBasket basket = new ShoppingBasket();
        basket.addItem(new ShoppingItem("imported bottle of perfume", ShoppingCategory.OTHER, true, new BigDecimal("27.99")));
        basket.addItem(new ShoppingItem("bottle of perfume", ShoppingCategory.OTHER, new BigDecimal("18.99")));
        basket.addItem(new ShoppingItem("packet of headache pills", ShoppingCategory.MEDICAL, new BigDecimal("9.75")));
        basket.addItem(new ShoppingItem("box of imported chocolates", ShoppingCategory.FOOD, true, new BigDecimal("11.25")));

        Receipt receipt = checkoutService.generateReceipt(basket, taxPolicy);
        printService.print(receipt);
    }
}
