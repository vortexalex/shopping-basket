package com.vortexalex.shoppingbasket.taxes;

import com.vortexalex.shoppingbasket.ShoppingItem;

import java.math.BigDecimal;
import java.util.Optional;

public class DefaultTaxPolicy {

    private static final BigDecimal TAX_RATE_PERC = new BigDecimal(10);

    private ExemptionPolicy exemptionPolicy;

    public DefaultTaxPolicy(ExemptionPolicy exemptionPolicy) {
        this.exemptionPolicy = exemptionPolicy;
    }

    public BigDecimal apply(ShoppingItem item) {
        return Optional.ofNullable(item)
                .filter(i -> !exemptionPolicy.isExempt(i))
                .map(i -> i.getPrice().multiply(TAX_RATE_PERC).divide(new BigDecimal(100)))
                .orElse(new BigDecimal(0));
    }

}
