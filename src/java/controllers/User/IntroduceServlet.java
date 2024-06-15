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
@WebServlet(name = "IntroduceServlet", urlPatterns = {"/introduce"})
public class IntroduceServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/User/introduce-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Giới thiệu");

        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/User/Pages/introduce.jsp").forward(request, response);

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
