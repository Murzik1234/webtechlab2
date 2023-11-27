package by.bsuir.shop.model.mappers;

import by.bsuir.shop.model.cart.CartItem;
import by.bsuir.shop.model.dao.ProductDao;
import by.bsuir.shop.model.dao.impl.JdbcProductDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsRowMapper {
    private ProductDao productDao = JdbcProductDao.getInstance();
    public List<CartItem> mapRows(ResultSet rs) throws SQLException {
        List<CartItem> cartItems = new ArrayList<>();
        while (rs.next()) {
            CartItem item = new CartItem();
            item.setQuantity(rs.getInt("quantity"));
            item.setProduct(productDao.getProduct(rs.getLong("cosmeticId")));
            cartItems.add(item);
        }
        return cartItems;
    }
}
