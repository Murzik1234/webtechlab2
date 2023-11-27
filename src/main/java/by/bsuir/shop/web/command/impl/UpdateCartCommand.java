package by.bsuir.shop.web.command.impl;

import by.bsuir.shop.model.cart.Cart;
import by.bsuir.shop.model.exception.NegativeNumberException;
import by.bsuir.shop.model.exception.OutOfStockException;
import by.bsuir.shop.model.service.CartService;
import by.bsuir.shop.model.service.impl.HttpSessionCartService;
import by.bsuir.shop.web.command.Command;
import by.bsuir.shop.web.command.CommandHandler;
import by.bsuir.shop.web.command.CommandName;
import jakarta.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class UpdateCartCommand implements Command {
    private CartService cartService = HttpSessionCartService.getInstance();
    @Override
    public String execute(HttpServletRequest request) {
        Long[] ids = Arrays.stream(request.getParameterValues("productId"))
                .map(id -> Long.parseLong(id))
                .toArray(Long[]::new);
        String[] quantities = request.getParameterValues("quantity");
        Map<Long, String> errors = new HashMap<>();
        Cart cart = cartService.getCart(request);
        for (int i = 0; i < ids.length; i++) {
            try {
                int quantity = Integer.parseInt(quantities[i]);
                if(quantity < 1) {
                    throw new NegativeNumberException();
                }
                cartService.update(cart, ids[i], quantity);
            } catch (NumberFormatException e) {
                errors.put(ids[i], "Quantity must be number");
            } catch (NegativeNumberException e) {
                errors.put(ids[i], "Quantity must be more than 0");
            } catch (OutOfStockException e) {
                errors.put(ids[i], String.format("Out of stock, max %d", e.getStock()));
            }
        }
        if(errors.isEmpty()) {
            request.setAttribute("updated", true);
        } else {
            request.setAttribute("errors", errors);
        }
        return CommandHandler.getInstance().getCommandByName(CommandName.CART).execute(request);
    }
}
