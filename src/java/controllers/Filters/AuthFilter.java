package controllers.Filters;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author VJames
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = {"/*"})
public class AuthFilter implements Filter {

    private static final boolean debug = true;

    private FilterConfig filterConfig = null;

    private static final String[] ALLOWED_PATHS = {
        "/home",
        "/service",
        "/login",
        "/verifyaccount",
        "/register",
        "/suggest",
        "/tourdetails",
        "/hoteldetails",
        "/restaurantdetails",
        "/payment",
        "/vnpayajax",
        "/paymentreturn",
        "/introduce",
        "/restaurantsearch",
        "/hotelsearch"};

    public AuthFilter() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());

        if (shouldBypassAuthentication(path)) {
            chain.doFilter(request, response); // Allow request to continue
            return;
        }

        Cookie[] cookies = httpRequest.getCookies();
        String isAuth = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("accessToken".equals(cookie.getName())) {
                    isAuth = cookie.getValue();
                    break;
                }
            }
        }

        if (isAuth != null) {
            httpRequest.getRequestDispatcher("/").forward(request, response); // User is authenticated, allow request to continue
        } else {
            httpRequest.getRequestDispatcher("/").forward(request, response);
        }
    }

    private boolean shouldBypassAuthentication(String path) {
        for (String allowedPath : ALLOWED_PATHS) {
            if (path.equals(allowedPath) || path.startsWith(allowedPath + "/")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    public void destroy() {
    }

    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;

    }

}
