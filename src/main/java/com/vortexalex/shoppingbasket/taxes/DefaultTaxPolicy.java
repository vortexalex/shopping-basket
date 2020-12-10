package com.vortexalex.shoppingbasket.taxes;

import com.vortexalex.shoppingbasket.ShoppingItem;

import java.math.BigDecimal;

public class DefaultTaxPolicy {

    public BigDecimal apply(ShoppingItem item) {
        return new BigDecimal(0);
    }

}
