package by.bsuir.shop.model.service;

import by.bsuir.shop.model.cart.Cart;

public interface StockService {
    int getAvailableQuantity(Cart cart, Long id);
}
