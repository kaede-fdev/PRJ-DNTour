package controllers.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tour;
import service.impl.TourService;
import service.interfaces.ITourService;
import utils.AppConstants;
import java.util.*;

/**
 *
 * @author VJames
 */
@WebServlet(name = "ServiceServlet", urlPatterns = {"/service"})
public class ServiceServlet extends HttpServlet {

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/User/service-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Dịch vụ");
        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/User/Pages/service.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ITourService tourService = new TourService();
        List<Tour> tours = tourService.getAllTours();
        NumberFormat currencyFormatter = NumberFormat.getInstance(new Locale("vi", "VN"));

        for (Tour tour : tours) {
            System.out.println(tour.getBackgroundImage());
            tour.setFormattedMinPrice(currencyFormatter.format(tour.getForChildTotalPrice()));
            tour.setFormattedMaxPrice(currencyFormatter.format(tour.getTotalPrice()));
        }

        request.setAttribute("tours", tours);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
