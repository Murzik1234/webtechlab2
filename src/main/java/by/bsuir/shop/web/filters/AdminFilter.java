package by.bsuir.shop.web.filters;

import by.bsuir.shop.model.user.User;
import by.bsuir.shop.model.user.UserRole;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String command = Optional.ofNullable(httpServletRequest.getParameter("command")).orElse("");
        User user = Optional.ofNullable((User)httpServletRequest.getSession().getAttribute("user")).orElse(new User());
        if(Optional.ofNullable(((HttpServletRequest) request).getPathInfo()).orElse("").startsWith("/styles")) {
            chain.doFilter(request, response);
        }
        if(user.getRole() != UserRole.ADMIN && command.equals("USERS")) {
            ((HttpServletResponse) response).sendRedirect("/controller?command=PRODUCT_LIST");
        } else {
            chain.doFilter(request, response);
        }
    }
}
