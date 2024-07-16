package controllers.User;

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
import javax.servlet.http.HttpSession;
import model.Hotel;
import model.Restaurant;
import model.Tour;
import model.TourImages;
import model.Tours;
import service.impl.HotelSearchService;
import service.impl.RestaurantSearchService;
import service.impl.TourService;
import service.impl.ToursService;
import service.interfaces.ITourService;
import utils.AppConstants;

/**
 *
 * @author VJames
 */
@WebServlet(name = "TourUpdateServlet", urlPatterns = {"/tourUpdate"})
public class TourUpdateServlet extends HttpServlet {

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/User/tour-update-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Tour Update");
        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/User/Pages/tour-update.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idParam = request.getParameter("id");
        int id = Integer.parseInt(idParam);

        ToursService tourService = new ToursService();
        Tours tours = tourService.getTourById(id);
        RestaurantSearchService restaurantSearchService = new RestaurantSearchService();
        List<Restaurant> restaurants = restaurantSearchService.getAllRestaurants();
        HotelSearchService hotelSearchService = new HotelSearchService();
        List<Hotel> hotels = hotelSearchService.getAllHotels();

        Hotel HotelbyId = hotelSearchService.getHotelById(tours.getHotelId());
        Restaurant restaurantsById = restaurantSearchService.getRestaurantById(tours.getRestaurantId());
        System.out.println(restaurants);
        System.out.println(tours.getTitle());

        HttpSession session = request.getSession();

        int tourPrice = tours.getTotalPrice();

        session.setAttribute("tourPrice", tourPrice);
        session.setAttribute("HotelbyId", HotelbyId);
        session.setAttribute("hotels", hotels);
        session.setAttribute("tours", tours);
        session.setAttribute("restaurantsById", restaurantsById);
        session.setAttribute("restaurants", restaurants);

        // Render the page
        renderPage(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String hotelPriceStr = request.getParameter("hotelPrice");
        String restaurantPriceStr = request.getParameter("restaurantPrice");

        HttpSession session = request.getSession();

        int hotelPrice = 0;
        int restaurantPrice = 0;
        try {
            hotelPrice = Integer.parseInt(hotelPriceStr);
            restaurantPrice = Integer.parseInt(restaurantPriceStr);
        } catch (NumberFormatException e) {

            e.printStackTrace(); // or log the error
        }
        RestaurantSearchService restaurantSearchService = new RestaurantSearchService();

        HotelSearchService hotelSearchService = new HotelSearchService();
        Hotel HotelbyId = hotelSearchService.getHotelByMinPrice(hotelPrice);
        Restaurant restaurantsById = restaurantSearchService.getRestaurantByMinPrice(restaurantPrice);

        int totalPrice = hotelPrice + restaurantPrice;
        session.setAttribute("HotelbyId", HotelbyId);
        session.setAttribute("restaurantsById", restaurantsById);
        request.setAttribute("tourPrice", totalPrice * 2 - 58000);

        renderPage(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
