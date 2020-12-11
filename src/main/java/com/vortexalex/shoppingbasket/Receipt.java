package com.vortexalex.shoppingbasket;

import com.vortexalex.shoppingbasket.ShoppingItem;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Receipt {

    private Map<ShoppingItem, BigDecimal> items;

    private BigDecimal taxes;

    private BigDecimal total;

    public Receipt(){
        items = new LinkedHashMap<>();
        taxes = new BigDecimal("0.00");
        total = new BigDecimal("0.00");
    }

    public Map<ShoppingItem, BigDecimal> getItems() {
        return items;
    }

    public BigDecimal getTaxes() {
        return taxes;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void addItem(ShoppingItem item, BigDecimal amount) {
        items.put(item, amount);
    }

    public void addTaxes(BigDecimal addedTaxes) {
        taxes = taxes.add(addedTaxes);
    }

    public void addTotal(BigDecimal subTotal) {
        total = total.add(subTotal);
    }

}
