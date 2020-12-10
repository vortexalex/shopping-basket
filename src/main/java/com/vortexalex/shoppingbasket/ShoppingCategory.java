package com.vortexalex.shoppingbasket;

public enum ShoppingCategory {

    BOOK,
    FOOD,
    MEDICAL,
    OTHER;

    public boolean contains(ShoppingCategory category) {
        for (ShoppingCategory c : values()) {
            if (c == category)
                return true;
        }
        return false;
    }
}
