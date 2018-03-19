package com.example.shop;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ShopTest {

    private int money;
    private Map<Item, Integer> stock;
    Shop shop;
    MusicPlayer musicPlayer;

    @Before
    public void init() {
        money = 2000;
        stock = new HashMap<>();
        stock.put(new Item("chleb", 0, 12, true), 4);
        stock.put(new Item("mleko", 0, 3, true), 6);
        stock.put(new Item("piwo", 18, 5, true), 22);
        musicPlayer = Mockito.mock(MusicPlayer.class);

        shop = new Shop(money, stock, musicPlayer);
    }

    @Test
    public void showIsItemInShop() {
        //give
        String productName = "mleko";
        //when
        boolean result = shop.hasItem(productName);
        //then
        Assert.assertThat(result, CoreMatchers.is(true));
    }

    @Test
    public void playCashSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        //give
        //when
        musicPlayer.playsound();
        //then
        Mockito.verify(musicPlayer).playsound();
    }


}