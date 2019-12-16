package service;

import domain.Item;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import repository.BasketRepository;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BasketTest {
    private Basket basket;
    @Mock
    private BasketRepository basketRepository;

    @Before
    public void setup() {
        basket = new Basket(basketRepository);
    }

    @Test
    public void should_add_an_item_in_basket_with_price() {
        Item itemA = new Item(90);

        basket.addItem(itemA);

        verify(basketRepository).addItem(itemA);
    }

    @Test
    public void should_add_multiple_items_in_basket_with_their_prices() {
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
