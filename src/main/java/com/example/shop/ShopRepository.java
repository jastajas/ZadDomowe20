package com.example.shop;

import org.springframework.stereotype.Repository;

@Repository
public class ShopRepository {

    private Shop shop;


    public ShopRepository(Shop shop) {
        this.shop = shop;
    }

    public Shop findShop() {
        return shop;
        /* ta metoda z premedytacją nic nie zwraca. W prawdziwym wypadku byłoby tutaj połączenie z bazą danych
         * która zwraca aktualny stan z bazy. W tym zadaniu chodzi o to, żeby przygotować dane testowe które nie pochodzą
         * z bazy danych */
    }

}
