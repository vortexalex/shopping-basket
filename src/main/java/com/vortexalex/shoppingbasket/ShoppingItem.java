package com.vortexalex.shoppingbasket;

import java.math.BigDecimal;

public class ShoppingItem {

    private String description;

    private ShoppingCategory category;

    private BigDecimal price;

    public ShoppingItem(String description, ShoppingCategory category, BigDecimal price) {
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public ShoppingCategory getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
