package com.vortexalex.shoppingbasket;

import java.math.BigDecimal;

public class ShoppingItem {

    private String description;

    private BigDecimal price;

    ShoppingItem(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
    }

    String getDescription() {
        return description;
    }

    BigDecimal getPrice() {
        return price;
    }
}
