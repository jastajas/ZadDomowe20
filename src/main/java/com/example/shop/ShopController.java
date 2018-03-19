package com.example.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping
@Controller
public class ShopController {

    private Shop shop;


    public ShopController(ShopRepository shopRepository) {
        shop = shopRepository.findShop();
    }

    public Shop getShop() {
        return shop;
    }

    @RequestMapping("/new")
    @ResponseBody
    public void sellItem(Human human, @RequestParam String itemName) {

        if (shop.hasItem(itemName)) {
            Item item = shop.findItemByName(itemName);
            if (item.getAgeRestriction() > human.getAge()) {
                throw new TooYoungException("WIEK");
            } else if (!item.isLegal() && human.getJob().equals("policjant")) {
                throw new BandSaleException();
            } else if (human.getMoney() < item.getPrice()) {
                throw new ToLittleMoneyException();
            } else {
                int newMoney = human.getMoney() - item.getPrice();
                human.setMoney(newMoney);
                shop.setMoney(shop.getMoney() + item.getPrice());
                if (shop.getStock().get(item) - 1 != 0) {
                    shop.getStock().put(item, shop.getStock().get(item) - 1);
                } else {
                    shop.getStock().remove(item);
                }
                shop.playCashSound();
            }
        } else {
            throw new OutOfStockException();
        }
    }

}
