package controllers.User;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.AppConstants;

/**
 *
 * @author VJames
 */
@WebServlet(name = "ServiceServlet", urlPatterns = {"/service"})
public class ServiceServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/User/service-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Dịch vụ");

        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/User/Pages/service.jsp").forward(request, response);

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
