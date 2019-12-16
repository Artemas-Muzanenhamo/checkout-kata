package service;

import domain.Item;
import repository.BasketRepository;

public class Basket {
    private BasketRepository basketRepository;

    public Basket(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    public void addItem(Item item) {
        basketRepository.addItem(item);
    }
}
