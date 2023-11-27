package by.bsuir.shop.web.command.impl;

import by.bsuir.shop.model.order.Order;
import by.bsuir.shop.model.service.CartService;
import by.bsuir.shop.model.service.OrderService;
import by.bsuir.shop.model.service.impl.JdbcOrderService;
import by.bsuir.shop.model.service.impl.HttpSessionCartService;
import by.bsuir.shop.web.JspPageName;
import by.bsuir.shop.web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class CheckoutCommand implements Command {
    private CartService cartService = HttpSessionCartService.getInstance();
    private OrderService orderService = JdbcOrderService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        Order order = orderService.getOrder(cartService.getCart(request));
        request.setAttribute("order", order);
        return JspPageName.CHECKOUT_JSP;
    }
}
