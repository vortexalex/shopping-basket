package com.vortexalex.shoppingbasket;

import java.math.BigDecimal;

public class ShoppingItem {

    private String description;

    private ShoppingCategory category;

    private boolean imported;

    private BigDecimal price;

    public ShoppingItem(String description, ShoppingCategory category, BigDecimal price) {
        this(description, category, false, price);
    }

    public ShoppingItem(String description, ShoppingCategory category, boolean imported, BigDecimal price) {
        this.description = description;
        this.category = category;
        this.imported = imported;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public ShoppingCategory getCategory() {
        return category;
    }

    public boolean getImported() {
        return imported;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
