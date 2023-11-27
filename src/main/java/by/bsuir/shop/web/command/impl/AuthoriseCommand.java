package by.bsuir.shop.web.command.impl;

import by.bsuir.shop.model.dao.UserDao;
import by.bsuir.shop.model.dao.impl.JdbcUserDao;
import by.bsuir.shop.model.user.User;
import by.bsuir.shop.web.JspPageName;
import by.bsuir.shop.web.command.Command;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.util.Optional;

public class AuthoriseCommand implements Command {
    private UserDao userDao = JdbcUserDao.getInstance();

    @Override
    public String execute(HttpServletRequest request) {
        String login = Optional.ofNullable(request.getParameter("login")).orElse("");
        String password = Optional.ofNullable(request.getParameter("password")).orElse("");
        Optional<User> user;
        try {
            user = userDao.getUser(login, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (user.isPresent()) {
            request.getSession().setAttribute("user", user.get());
        }
        return JspPageName.LOGIN_JSP;
    }
}
