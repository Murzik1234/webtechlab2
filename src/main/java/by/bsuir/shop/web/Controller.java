package by.bsuir.shop.web;

import by.bsuir.shop.model.service.CartService;
import by.bsuir.shop.model.service.impl.HttpSessionCartService;
import by.bsuir.shop.web.command.CommandHandler;
import by.bsuir.shop.web.command.CommandName;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Controller extends HttpServlet {
    private CommandHandler commandHandler = CommandHandler.getInstance();
    private CartService cartService = HttpSessionCartService.getInstance();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("command");
        CommandName commandName = CommandName.valueOf(name);
        String page = commandHandler.getCommandByName(commandName).execute(request);
        request.setAttribute("command", name);
        request.setAttribute("cart", cartService.getCart(request));
        request.getRequestDispatcher(page).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("command");
        CommandName commandName = CommandName.valueOf(name);
        String page = commandHandler.getCommandByName(commandName).execute(request);
        request.setAttribute("command", name);
        request.setAttribute("cart", cartService.getCart(request));
        request.getRequestDispatcher(page).forward(request, response);
    }
}
