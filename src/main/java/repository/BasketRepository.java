package repository;

import domain.Item;

import java.util.ArrayList;
import java.util.List;

public class BasketRepository {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getAllItems() {
        return items;
    }

    public int getTotalPriceForBasket(List<Item> items) {
        return items.stream()
                .mapToInt(Item::getPrice)
                .sum();
    }
}
