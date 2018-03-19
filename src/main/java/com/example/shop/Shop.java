package com.example.shop;

import org.springframework.stereotype.Component;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class Shop {

    private int money;
    private Map<Item, Integer> stock;
    MusicPlayer musicPlayer;

    public Shop() {
        Map<Item, Integer> stocki = new HashMap<>();
        stocki.put(new Item("chleb", 0, 12, true), 4);
        stocki.put(new Item("mleko", 0, 3, true), 6);
        stocki.put(new Item("piwo", 18, 5, true), 22);

        musicPlayer = new MusicPlayer();
        money = 0;
        stock = stocki;

    }


    public Shop(int money, Map<Item, Integer> stock, MusicPlayer musicPlayer) {
        this.money = money;
        this.stock = stock;
        this.musicPlayer = musicPlayer;
    }

    public void playCashSound() {

        try {
            musicPlayer.playsound();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public boolean hasItem(String itemName) {

        for (Item item : stock.keySet()) {
            if (item.getName().equals(itemName))
                return true;
        }
        return false;
    }

    public Item findItemByName(String itemName) {

        for (Item item : stock.keySet()) {
            if (item.getName().equals(itemName))
                return item;
        }

        return null;
    }

    public int getMoney() {
        return money;
    }

    public Map<Item, Integer> getStock() {
        return stock;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
