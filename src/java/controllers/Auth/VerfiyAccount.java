package controllers.Auth;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import service.impl.AuthSerivce;
import service.interfaces.IAuthService;
import utils.AppConstants;

/**
 *
 * @author VJames
 */
@WebServlet(name = "VerfiyAccount", urlPatterns = {"/verifyaccount"})
public class VerfiyAccount extends HttpServlet {

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/Auth/verified-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Xác thực thành công!");
        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/Auth/Pages/verified.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emailStr = request.getParameter("email");
        System.out.println(emailStr);

        IAuthService authService = new AuthSerivce();
        User user = authService.findUserByEmail(emailStr);

        if (user != null && !user.isVerify()) {
            authService.updateUserVerifyByEmail(true, emailStr);
            request.setAttribute("message", "Tài khoản của bạn đã xác thực thành công");
        } else {
            request.setAttribute("message", "Không tìm thấy tài khoản");
        }

        renderPage(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
