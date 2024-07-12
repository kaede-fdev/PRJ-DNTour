package controllers.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Tour;
import model.TourImages;
import service.impl.TourService;
import service.interfaces.ITourService;
import utils.AppConstants;

/**
 *
 * @author VJames
 */
public class TourDetailsServlet extends HttpServlet {

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/User/tour-details-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Tour Details");
        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/User/Pages/tour-details.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (String) request.getParameter("id");

        NumberFormat currencyFormatter = NumberFormat.getInstance(new Locale("vi", "VN"));
        ITourService tourService = new TourService();
        Tour tour = tourService.getTourById(Integer.parseInt(id));
        tour.setFormattedMinPrice(currencyFormatter.format(tour.getForChildTotalPrice()));
        tour.setFormattedMaxPrice(currencyFormatter.format(tour.getTotalPrice()));
        List<TourImages> tourImages = tourService.getAllTourImagesById(Integer.parseInt(id));
        List<Tour> tours = tourService.getTopThreeToursMinusById(Integer.parseInt(id));
        for (Tour tourItem : tours) {
            tourItem.setFormattedMinPrice(currencyFormatter.format(tour.getForChildTotalPrice()));
            tourItem.setFormattedMaxPrice(currencyFormatter.format(tour.getTotalPrice()));
        }

        request.setAttribute("tour", tour);
        request.setAttribute("tourImages", tourImages);
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
