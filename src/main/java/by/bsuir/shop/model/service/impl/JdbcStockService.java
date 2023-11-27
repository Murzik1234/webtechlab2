package by.bsuir.shop.model.service.impl;

import by.bsuir.shop.model.Product;
import by.bsuir.shop.model.cart.Cart;
import by.bsuir.shop.model.dao.ProductDao;
import by.bsuir.shop.model.dao.impl.JdbcProductDao;
import by.bsuir.shop.model.service.StockService;

public class JdbcStockService implements StockService {
    private static class SingletonHandler {
        private static final JdbcStockService INSTANCE = new JdbcStockService();
    }

    public static JdbcStockService getInstance() {
        return SingletonHandler.INSTANCE;
    }

    private ProductDao productDao = JdbcProductDao.getInstance();

    private JdbcStockService() {

    }

    @Override
    public int getAvailableQuantity(Cart cart, Long id) {
        Product product = productDao.getProduct(id);
        int existedQuantity = cart.getItems().stream()
                .filter(item -> item.getProduct().equals(product))
                .map(item -> item.getQuantity())
                .findFirst().orElse(0);
        return product.getStock() - existedQuantity;
    }
}