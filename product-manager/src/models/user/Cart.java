package models.user;

import models.electronic.Electronic;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Electronic, Integer> items = new HashMap<>();

    public Map<Electronic, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Electronic, Integer> items) {
        this.items = items;
    }

    public void clear() {
        items.clear();
    }
}
