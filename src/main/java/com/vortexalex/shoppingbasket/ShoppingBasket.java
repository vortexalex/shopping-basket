package com.vortexalex.shoppingbasket;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    private List<ShoppingItem> items = new ArrayList<>();

    public void addItem(ShoppingItem item) {
        items.add(item);
    }

    public ShoppingItem getItem(Integer index) {
        return items.get(index);
    }

    public Integer getSize() {
        return items.size();
    }

    public List<ShoppingItem> getItems() {
        return items;
    }




}
