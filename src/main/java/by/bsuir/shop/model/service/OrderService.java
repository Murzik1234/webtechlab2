package by.bsuir.shop.model.service;

import by.bsuir.shop.model.cart.Cart;
import by.bsuir.shop.model.order.Order;

import java.sql.SQLException;

public interface OrderService {
    Order getOrder(Cart cart);
    void placeOrder(Order order) throws SQLException;
}
