package by.bsuir.shop.web.command.impl;

import by.bsuir.shop.model.cart.Cart;
import by.bsuir.shop.model.service.CartService;
import by.bsuir.shop.model.service.impl.HttpSessionCartService;
import by.bsuir.shop.web.JspPageName;
import by.bsuir.shop.web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class DeleteCartItemCommand implements Command {
    private CartService cartService = HttpSessionCartService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        Long phoneId = Long.parseLong(request.getParameter("phoneId"));
        Cart cart = cartService.getCart(request);
        cartService.delete(cart, phoneId);
        request.setAttribute("deleted", true);
        return JspPageName.CART_JSP;
    }
}
