package by.bsuir.shop.web.command.impl;

import by.bsuir.shop.model.service.CartService;
import by.bsuir.shop.model.service.impl.HttpSessionCartService;
import by.bsuir.shop.web.JspPageName;
import by.bsuir.shop.web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class CartCommand implements Command {
    private CartService cartService = HttpSessionCartService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("cart", cartService.getCart(request));
        return JspPageName.CART_JSP;
    }
}
