package controllers.Auth;

import java.io.IOException;
import java.io.PrintWriter;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import service.interfaces.IAuthService;
import service.impl.AuthSerivce;
import utils.AppConstants;
import utils.MailSender;

/**
 *
 * @author VJames
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/Auth/register-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Đăng ký");
        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/Auth/Pages/register.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
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
                renderPage(request, response);
                return;
            }

            // Kiểm tra xác nhận mật khẩu
            if (!passwordStr.equals(confirmPasswordStr)) {
                request.setAttribute("errorMessage", "Mật khẩu và xác nhận mật khẩu không khớp.");
                renderPage(request, response);
                return;
            }

            IAuthService authService = new AuthSerivce();
            // Kiểm tra người dùng đã tồn tại hay chưa
            User foundUser = authService.findUserByEmail(emailStr);
            System.out.println(foundUser);
            if (foundUser != null && foundUser.getEmail().equals(emailStr)) {
                request.setAttribute("errorMessage", "Người dùng đã tồn tại!");
                renderPage(request, response);
                return;
            }

            String fromHost = "http://localhost:8080/DanaTours/verifyaccount?email=";

            String verifyLink = fromHost + emailStr;
            String subject = "DANATOUR | Xác thực tài khoản!";
            String content = "<p>Click vào link bên dưới để xác thực tài khoản:</p>"
                    + "<a href=\"" + verifyLink + "\">Click Here</a>";

            MailSender mailSender = new MailSender();

            mailSender.sendEmail(emailStr, subject, content);

            // Tạo mới người dùng
            authService.createNewUser(fullnameStr, emailStr, passwordStr);
            // Chuyển hướng người dùng sau khi đăng ký thành công
            response.sendRedirect(request.getContextPath() + "/checkverify");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    }// </editor-fold>

}
