package by.bsuir.shop.web.command.impl;

import by.bsuir.shop.model.Product;
import by.bsuir.shop.model.dao.ProductDao;
import by.bsuir.shop.model.dao.impl.JdbcProductDao;
import by.bsuir.shop.web.JspPageName;
import by.bsuir.shop.web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class ProductDetailsCommand implements Command {
    private ProductDao productDao = JdbcProductDao.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        Long id = Long.valueOf(request.getParameter("id"));
        Product product = productDao.getProduct(id);
        request.setAttribute("cosmetic", product);
        return JspPageName.PRODUCT_DETAILS_JSP;
    }
}
