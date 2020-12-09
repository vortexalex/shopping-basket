package com.vortexalex.shoppingbasket;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    private List<ShoppingItem> items = new ArrayList<>();

    void addItem(ShoppingItem item) {
        items.add(item);
    }

    ShoppingItem getItem(Integer index) {
        return items.get(index);
    }

    Integer getSize() {
        return items.size();
    }


}
