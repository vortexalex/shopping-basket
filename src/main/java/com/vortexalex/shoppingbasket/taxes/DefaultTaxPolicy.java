package com.vortexalex.shoppingbasket.taxes;

import com.vortexalex.shoppingbasket.ShoppingItem;
import com.vortexalex.shoppingbasket.util.Rounding;

import java.math.BigDecimal;

public class DefaultTaxPolicy {

    private static final BigDecimal TAX_RATE_PERC = new BigDecimal("10");
    private static final BigDecimal IMPORT_TAX_RATE_PERC = new BigDecimal("5");

    private ExemptionPolicy exemptionPolicy;

    public DefaultTaxPolicy(ExemptionPolicy exemptionPolicy) {
        this.exemptionPolicy = exemptionPolicy;
    }

    public BigDecimal apply(ShoppingItem item) {
         BigDecimal result = new BigDecimal("0");
         if (!exemptionPolicy.isExempt(item)) {
             result = result.add(item.getPrice().multiply(TAX_RATE_PERC).divide(new BigDecimal("100")));
         }
         if (item.getImported()) {
             result = result.add(item.getPrice().multiply(IMPORT_TAX_RATE_PERC).divide(new BigDecimal("100")));
         }
         return Rounding.round(result);
    }

}
