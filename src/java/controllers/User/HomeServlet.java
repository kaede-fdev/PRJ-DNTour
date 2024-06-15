package controllers.User;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.AppConstants;

/**
 *
 * @author VJames
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/"})
public class HomeServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/User/home-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Trang chủ");

        //Check Auth
        Cookie[] cookies = request.getCookies();
        String accessToken = null;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("accessToken".equals(cookie.getName())) {
                    accessToken = cookie.getValue();
                    break;
                }
            }
        }

        try {
            if (accessToken != null) {
                request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/User/Pages/home.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/User/Pages/home.jsp").forward(request, response);

            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServletException("Error forwarding to home.jsp", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
