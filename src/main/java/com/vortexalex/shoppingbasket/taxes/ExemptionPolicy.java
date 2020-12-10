package com.vortexalex.shoppingbasket.taxes;

import com.vortexalex.shoppingbasket.ShoppingItem;
import com.vortexalex.shoppingbasket.ShoppingCategory;

public class ExemptionPolicy {

    public boolean isExempt(ShoppingItem item) {
        return item.getCategory() != ShoppingCategory.OTHER;
    }
}
