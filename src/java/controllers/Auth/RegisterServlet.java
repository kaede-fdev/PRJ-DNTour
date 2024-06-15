package controllers.Auth;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.impl.IAuthService;
import service.interfaces.AuthSerivce;
import utils.AppConstants;

/**
 *
 * @author VJames
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullnameStr = request.getParameter("fullname");
        String passwordStr = request.getParameter("password");
        String emailStr = request.getParameter("email");
        String confirmPasswordStr = request.getParameter("confirmPassword");

        System.out.println(fullnameStr);
        System.out.println(passwordStr);
        System.out.println(emailStr);
        System.out.println(confirmPasswordStr);

        // Kiểm tra xem các trường thông tin có bị null hoặc rỗng không
        if (fullnameStr == null || fullnameStr.isEmpty()
                || passwordStr == null || passwordStr.isEmpty()
                || emailStr == null || emailStr.isEmpty()
                || confirmPasswordStr == null || confirmPasswordStr.isEmpty()) {
            request.setAttribute("errorMessage", "Vui lòng điền đầy đủ thông tin.");
            request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/Auth/register-page.jsp");
            request.setAttribute("pageTitle", "DNTour - Đăng ký");
            request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/Auth/Pages/register.jsp").forward(request, response);
            return;
        }

        // Kiểm tra xác nhận mật khẩu
        if (!passwordStr.equals(confirmPasswordStr)) {
            request.setAttribute("errorMessage", "Mật khẩu và xác nhận mật khẩu không khớp.");
            request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/Auth/register-page.jsp");
            request.setAttribute("pageTitle", "DNTour - Đăng ký");
            request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/Auth/Pages/register.jsp").forward(request, response);
            return;
        }

        // Tạo mới người dùng
        IAuthService authService = new AuthSerivce();
        authService.createNewUser(fullnameStr, emailStr, passwordStr);
        // Chuyển hướng người dùng sau khi đăng ký thành công
        response.sendRedirect(request.getContextPath() + "/login");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/Auth/register-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Đăng ký");

        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/Auth/Pages/register.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
