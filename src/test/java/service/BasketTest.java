package service;

import domain.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.BasketRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BasketTest {
    private Basket basket;
    @Mock
    private BasketRepository basketRepository;

    @BeforeEach
    void setup() {
        basket = new Basket(basketRepository);
    }

    @Test
    @DisplayName("Should add an Item in basket with price")
    void addItemsInBasketWithPrice() {
        Item itemA = new Item(90);

        basket.addItem(itemA);

        verify(basketRepository).addItem(itemA);
    }

    @Test
    @DisplayName("Should add multiple Items in basket with their prices")
    void addItemsWithPrices() {
        Item itemA = new Item(40);
        Item itemB = new Item(50);
        Item itemC = new Item(60);
        Item itemD = new Item(80);

        basket.addItem(itemA);
        basket.addItem(itemB);
        basket.addItem(itemC);
        basket.addItem(itemD);

        verify(basketRepository, times(4)).addItem(any(Item.class));
    }
}
