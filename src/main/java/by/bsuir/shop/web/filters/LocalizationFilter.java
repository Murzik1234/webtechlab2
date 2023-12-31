package by.bsuir.shop.web.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

public class LocalizationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if(Optional.ofNullable(((HttpServletRequest) request).getPathInfo()).orElse("").startsWith("/styles")) {
            chain.doFilter(request, response);
        }
        if (req.getSession().getAttribute("lang") == null) {
            req.getSession().setAttribute("lang", "en");
        }
        if (req.getParameter("locale") != null) {
            req.getSession().setAttribute("lang", req.getParameter("locale"));
        }
        chain.doFilter(request, response);
    }
}