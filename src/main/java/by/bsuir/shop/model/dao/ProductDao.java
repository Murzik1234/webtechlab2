package by.bsuir.shop.model.dao;

import by.bsuir.shop.model.Product;
import by.bsuir.shop.model.dao.sort.SortOrder;
import by.bsuir.shop.model.dao.sort.SortType;

import java.util.List;

public interface ProductDao {
    Product getProduct(Long id);

    List<Product> findProducts(String search, SortType type, SortOrder order);

}
