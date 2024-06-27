package controllers.Auth;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import service.impl.AuthSerivce;
import utils.*;
import service.interfaces.IAuthService;

/**
 *
 * @author VJames
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/Auth/login-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Đăng nhập");
        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/Auth/Pages/login.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.removeAttribute("errorMessage");
        renderPage(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //get request param
        String username = request.getParameter("email");
        String password = request.getParameter("password");
        IAuthService authService = new AuthSerivce();

        User foundUser = authService.findUserByEmail(username);

        if (foundUser == null) {
            request.setAttribute("errorMessage", "Tài khoản không tồn tại!");
            renderPage(request, response);
            return;
        }

        if (BScript.checkPassword(password, foundUser.getPassword())) {
            String token = Jwt.generateToken(foundUser);
            System.out.println("Token" + token);
            Cookie accessTokenCookie = new Cookie("accessToken", token);
            Cookie isAuth = new Cookie("isAuth", "true");
            response.addCookie(accessTokenCookie);
            response.addCookie(isAuth);
            response.sendRedirect(request.getContextPath());
            return;
        } else {
            request.setAttribute("errorMessage", "Mật khẩu không chính xác!");
            renderPage(request, response);
            return;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
