package com.vortexalex.shoppingbasket.printing;

import com.vortexalex.shoppingbasket.Receipt;
import com.vortexalex.shoppingbasket.ShoppingCategory;
import com.vortexalex.shoppingbasket.ShoppingItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class ConsolePrintServiceTest {

    private ConsolePrintService printService = new ConsolePrintService();

    @Test
    public void print() {
        Receipt receipt = new Receipt();
        receipt.addItem(new ShoppingItem("book", ShoppingCategory.BOOK, new BigDecimal("12.49")), new BigDecimal("12.49"));
        receipt.addItem(new ShoppingItem("music cd", ShoppingCategory.OTHER, new BigDecimal("14.99")), new BigDecimal("16.49"));
        receipt.addItem(new ShoppingItem("chocolate bar", ShoppingCategory.FOOD, new BigDecimal("0.85")), new BigDecimal("0.85"));
        receipt.addTaxes(new BigDecimal("1.50"));
        receipt.addTotal(new BigDecimal("29.83"));
        printService.print(receipt);
    }
}
