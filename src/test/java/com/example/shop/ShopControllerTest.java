package com.example.shop;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;


public class ShopControllerTest {

    ShopController shopController;

    private ShopRepository shopRepository;

    @Before
    public void init() {

        shopRepository = Mockito.mock(ShopRepository.class);

        shopController = new ShopController(shopRepository);


        Map<Item, Integer> stock = new HashMap<>();
        stock.put(new Item("chleb", 0, 12, true), 4);
        stock.put(new Item("mleko", 0, 3, true), 6);
        stock.put(new Item("piwo", 18, 5, true), 22);

        MusicPlayer musicPlayer = new MusicPlayer();

        Shop shop = new Shop(0, stock, musicPlayer);

        Mockito.when(shopRepository.findShop()).thenReturn(shop);

        shopController = Mockito.mock(ShopController.class);

    }

    @Test
    public void shopSell() {
        //give
        Human human = new Human("Jan", 20, "lekarz", 20);
        String productName = "mleko";
        //when
        shopController.sellItem(human, productName);
        //then
        Mockito.verify(shopController).sellItem(human, productName);
    }

    @Test(expected = TooYoungException.class)
    public void shouldNotSellBeerToYoungling() {
        // given
        Human human = new Human("Jan", 12, "lekarz", 20);
        String productName = "piwo";
        // when
        shopController.sellItem(human, productName);
    }


    @Test
    public void milkSellShopProfits() {
        //give
        Human human = new Human("Jan", 20, "lekarz", 20);
        String productName = "mleko";
        //when
        shopController.sellItem(human, productName);
        int result = shopController.getShop().getMoney();
        //then
        Assert.assertThat(result, CoreMatchers.is(6));
    }

    @Test
    public void humanMoneyAfterMilk() {
        //give
        Human human = new Human("Jan", 20, "lekarz", 20);
        String productName = "mleko";
        //when
        shopController.sellItem(human, productName);
        int result = human.getMoney();
        //then
        Assert.assertThat(result, CoreMatchers.is(14));
    }

    @Test
    public void numItems() {
        //give
        Human human = new Human("Jan", 20, "lekarz", 20);
        String productName = "mleko";
        //when
        shopController.sellItem(human, productName);
        int result = shopRepository.findShop().getStock().get(shopRepository.findShop().findItemByName("mleko"));
        //then
        Assert.assertThat(result, CoreMatchers.is(5));
    }


}
