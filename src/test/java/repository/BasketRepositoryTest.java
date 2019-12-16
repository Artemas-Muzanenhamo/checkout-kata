package repository;

import domain.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BasketRepositoryTest {
    private static final int ITEM_A_PRICE = 50;
    private static final int ITEM_B_PRICE = 30;
    private BasketRepository basketRepository;

    @Before
    public void setup() {
        basketRepository = new BasketRepository();
    }

    @Test
    public void should_add_item_to_basket_repository() {
        Item expectedItem = new Item(ITEM_A_PRICE);

        basketRepository.addItem(expectedItem);
        List<Item> items = basketRepository.getAllItems();

        assertNotNull(items);
        Item item = items.get(0);
        assertEquals(item, expectedItem);
    }

    @Test
    public void should_add_item_with_price_to_basket_repository() {
        Item expectedItem = new Item(ITEM_A_PRICE);

        basketRepository.addItem(expectedItem);
        List<Item> items = basketRepository.getAllItems();

        assertNotNull(items);
        Item item = items.get(0);
        assertEquals(item, expectedItem);
        assertEquals(item.getPrice(), expectedItem.getPrice());
    }

    @Test
    public void should_return_all_items_in_basket() {
        Item expectedItem = new Item(ITEM_A_PRICE);
        basketRepository.addItem(expectedItem);

        List<Item> items = basketRepository.getAllItems();

        Item item = items.get(0);
        assertEquals(item, expectedItem);
    }

    @Test
    public void should_return_total_price_for_item_a() {
        Item itemA = new Item(ITEM_A_PRICE);
        basketRepository.addItem(itemA);
        List<Item> items = basketRepository.getAllItems();

        int totalPrice = basketRepository.getTotalPriceForBasket(items);

        assertEquals(totalPrice, ITEM_A_PRICE);
    }

    @Test
    public void should_return_total_price_for_item_a_and_item_b() {
        Item itemA = new Item(ITEM_A_PRICE);
        Item itemB = new Item(ITEM_B_PRICE);
        basketRepository.addItem(itemA);
        basketRepository.addItem(itemB);
        List<Item> items = basketRepository.getAllItems();

        int totalPrice = basketRepository.getTotalPriceForBasket(items);

        assertEquals(totalPrice, 80);
    }
}
