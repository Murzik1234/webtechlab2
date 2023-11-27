package by.bsuir.shop.model.mappers;

import by.bsuir.shop.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper {
    public Product mapRows(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setCountry(rs.getString("country"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getBigDecimal("price"));
        product.setImageUrl(rs.getString("imageUrl"));
        product.setName(rs.getString("name"));
        product.setWeight(rs.getInt("weight"));
        product.setId(rs.getLong("id"));
        product.setStock(rs.getInt("stock"));
        return product;
    }
}
