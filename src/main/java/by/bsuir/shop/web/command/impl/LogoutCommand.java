package by.bsuir.shop.web.command.impl;

import by.bsuir.shop.web.JspPageName;
import by.bsuir.shop.web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        return JspPageName.LOGIN_JSP;
    }
}
