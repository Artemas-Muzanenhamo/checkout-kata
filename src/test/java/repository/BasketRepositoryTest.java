package repository;

import domain.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BasketRepositoryTest {
    private static final int ITEM_A_PRICE = 50;
    private static final int ITEM_B_PRICE = 30;
    private BasketRepository basketRepository;

    @BeforeEach
    void setup() {
        basketRepository = new BasketRepository();
    }

    @Test
    @DisplayName("Should add an Item to the basket repository")
    void addItemToBasketRepository() {
        Item expectedItem = new Item(ITEM_A_PRICE);

        basketRepository.addItem(expectedItem);
        List<Item> items = basketRepository.getAllItems();

        assertThat(items).isNotNull();
        Item item = items.get(0);
        assertThat(item).isEqualTo(expectedItem);
    }

    @Test
    @DisplayName("Should add an Item with price to the basket repository")
    void addItemWithPrice() {
        Item expectedItem = new Item(ITEM_A_PRICE);

        basketRepository.addItem(expectedItem);
        List<Item> items = basketRepository.getAllItems();

        assertThat(items).isNotNull();
        Item item = items.get(0);
        assertThat(item).isEqualTo(expectedItem);
        assertThat(item.getPrice()).isEqualTo(expectedItem.getPrice());
    }

    @Test
    @DisplayName("Should return all items in the basket")
    void returnAllItemsInBasket() {
        Item expectedItem = new Item(ITEM_A_PRICE);
        basketRepository.addItem(expectedItem);

        List<Item> items = basketRepository.getAllItems();

        assertThat(items).isNotNull();
        Item item = items.get(0);
        assertThat(item).isEqualTo(expectedItem);
    }

    @Test
    @DisplayName("Should return total price for Item A in the basket")
    void shouldReturnTotalPriceForItem() {
        Item itemA = new Item(ITEM_A_PRICE);
        basketRepository.addItem(itemA);
        List<Item> items = basketRepository.getAllItems();

        int totalPrice = basketRepository.getTotalPriceForBasket(items);

        assertThat(totalPrice).isEqualTo(ITEM_A_PRICE);
    }

    @Test
    @DisplayName("Should return total price for Item A and Item B in the basket")
    void returnTotalPriceForMultipleItemsInBasket() {
        Item itemA = new Item(ITEM_A_PRICE);
        Item itemB = new Item(ITEM_B_PRICE);
        basketRepository.addItem(itemA);
        basketRepository.addItem(itemB);
        List<Item> items = basketRepository.getAllItems();

        int totalPrice = basketRepository.getTotalPriceForBasket(items);

        assertThat(totalPrice).isEqualTo(80);
    }
}
