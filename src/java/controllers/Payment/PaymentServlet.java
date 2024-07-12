package controllers.Payment;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tour;
import service.impl.TourService;
import service.interfaces.ITourService;
import utils.AppConstants;

/**
 *
 * @author VJames
 */
@WebServlet(name = "PaymentServlet", urlPatterns = {"/payment"})
public class PaymentServlet extends HttpServlet {

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/User/payment-page.jsp");
        request.setAttribute("pageTitle", "DNTour -  Thanh Toán");
        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/User/Pages/payment.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tourId = request.getParameter("tourId");
        System.out.println("tourID:" + tourId);

        ITourService tourService = new TourService();
        NumberFormat currencyFormatter = NumberFormat.getInstance(new Locale("vi", "VN"));

        Tour tour = tourService.getTourById(Integer.parseInt(tourId));
        tour.setFormattedMaxPrice(currencyFormatter.format(tour.getTotalPrice()));
        tour.setFormattedMinPrice(currencyFormatter.format(tour.getForChildTotalPrice()));

        request.setAttribute("tour", tour);
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
