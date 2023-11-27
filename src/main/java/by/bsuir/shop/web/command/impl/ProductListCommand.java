package by.bsuir.shop.web.command.impl;

import by.bsuir.shop.model.dao.ProductDao;
import by.bsuir.shop.model.dao.impl.JdbcProductDao;
import by.bsuir.shop.model.dao.sort.SortOrder;
import by.bsuir.shop.model.dao.sort.SortType;
import by.bsuir.shop.web.JspPageName;
import by.bsuir.shop.web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

public class ProductListCommand implements Command {
    private ProductDao productDao = JdbcProductDao.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        String search = Optional.ofNullable(request.getParameter("search")).orElse("");
        String typeParam = request.getParameter("sort");
        String orderParam = request.getParameter("order");
        SortType type = typeParam == null ? null : SortType.valueOf(typeParam);
        SortOrder order = orderParam == null ? null : SortOrder.valueOf(orderParam);
        request.setAttribute("cosmetics", productDao.findProducts(search, type, order));
        return JspPageName.PRODUCT_LIST_JSP;
    }
}
