package com.vortexalex.shoppingbasket.checkout;

import com.vortexalex.shoppingbasket.Receipt;
import com.vortexalex.shoppingbasket.ShoppingBasket;
import com.vortexalex.shoppingbasket.taxes.TaxPolicy;

import java.math.BigDecimal;

public class CheckoutService {

    public Receipt generateReceipt(ShoppingBasket basket, TaxPolicy taxPolicy) {
        Receipt receipt = new Receipt();
        basket.getItems().forEach(i -> {
            BigDecimal tax = taxPolicy.apply(i);
            BigDecimal subTotal = i.getPrice().add(tax);
            receipt.addItem(i, subTotal);
            receipt.addTaxes(tax);
            receipt.addTotal(subTotal);
        });
        return receipt;
    }
}
