package by.bsuir.shop.web.command.impl;

import by.bsuir.shop.model.dao.OrderDao;
import by.bsuir.shop.model.dao.impl.JdbcOrderDao;
import by.bsuir.shop.model.order.Order;
import by.bsuir.shop.web.JspPageName;
import by.bsuir.shop.web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;

public class OrderOverviewCommand implements Command {
    private OrderDao orderDao = JdbcOrderDao.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String secureId = request.getParameter("secureId");
        Order order;
        try {
            order = orderDao.getOrderBySecureId(secureId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        request.setAttribute("order", order);
        return JspPageName.ORDER_OVERVIEW_JSP;
    }
}
