package com.example.shop;

import org.springframework.stereotype.Component;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.Map;


public class Shop {

    private int money;
    private Map<Item, Integer> stock;
    MusicPlayer musicPlayer;


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
        // TODO dodaj kod sprawdzający czy sklep na w asortymencie przedmot o danej nazwie
        return false;
    }

    public Item findItemByName(String itemName) {

        for (Item item : stock.keySet()) {
            if (item.getName().equals(itemName))
                return item;
        }

        // TODO dodaj kod wyszukujący przedmiot po jego nazwie
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
