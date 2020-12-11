package com.vortexalex.shoppingbasket.taxes;

import com.vortexalex.shoppingbasket.ShoppingItem;

import java.math.BigDecimal;

public interface TaxPolicy {

    BigDecimal apply(ShoppingItem item);
}
