package controllers.User;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.impl.TourService;
import service.interfaces.ITourService;
import utils.AppConstants;
import model.Tours;
import java.util.*;
import javax.servlet.http.HttpSession;
import service.impl.ToursService;
import service.interfaces.IToursService;

/**
 *
 * @author VJames
 */
@WebServlet(name = "SuggestServlet", urlPatterns = {"/suggest"})
public class SuggestServlet extends HttpServlet {

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/User/suggest-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Gợi ý");
        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/User/Pages/suggest.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        renderPage(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("abc1231");
        IToursService tourService = new ToursService();
        List<Tours> tours = tourService.getAllTours();
        System.out.println(tours);
        // Set tours as a session attribute
        HttpSession session = request.getSession();
        session.setAttribute("tours", tours);
        renderPage(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("abc1");
        String priceStr = request.getParameter("price");
        int price = 0;

        if (priceStr != null && !priceStr.isEmpty()) {
            try {
                price = Integer.parseInt(priceStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Handle error: invalid input
                request.setAttribute("error", "Invalid price value.");
                renderPage(request, response);
                return;
            }
        }

        // Fetch tours by price
        ToursService tourService = new ToursService();
        List<Tours> tours = tourService.getToursByPrice(price);
        System.out.println(tours);

        // Set tours as a request attribute
        request.setAttribute("tours", tours);

        // Render the page with the tour suggestions
        renderPage(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
