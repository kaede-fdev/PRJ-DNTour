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
import model.Restaurant;
import model.Hotel;
import model.HotelImages;
import model.RestaurantImages;
import model.Tour;
import service.impl.HotelService;
import service.impl.RestaurantService;
import service.impl.TourService;
import service.interfaces.IHotelService;
import service.interfaces.IRestaurantService;
import service.interfaces.ITourService;
import utils.AppConstants;

/**
 *
 * @author VJames
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/"})
public class HomeServlet extends HttpServlet {

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/User/home-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Trang chủ");
        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/User/Pages/home.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        IRestaurantService restaurantService = new RestaurantService();
        //Get Top Three Restaurants
        List<Restaurant> restaurants = restaurantService.getTopThreeRestaurant();
        NumberFormat currencyFormatter = NumberFormat.getInstance(new Locale("vi", "VN"));
        for (Restaurant restaurant : restaurants) {
            RestaurantImages backgroundImage = restaurantService.getBackgroundImageById(restaurant.getId());
            if (backgroundImage != null) {
                restaurant.setBackgroundImageUrl(backgroundImage.getUrl());
            }
            restaurant.setFormattedMinPrice(currencyFormatter.format(restaurant.getMinPrice()));
            restaurant.setFormattedMaxPrice(currencyFormatter.format(restaurant.getMaxPrice()));
        }
        IHotelService hotelService = new HotelService();
        List<Hotel> hotels = hotelService.getTopFourHotels();
        for (Hotel hotel : hotels) {
            HotelImages backgroundHotelImages = hotelService.getBackgroundImageById(hotel.getId());
            if (backgroundHotelImages != null) {
                hotel.setBackgroundImageUrl(backgroundHotelImages.getUrl());
            }
            hotel.setFormattedMaxPrice(currencyFormatter.format(hotel.getMaxPrice()));
            hotel.setFormattedMinPrice(currencyFormatter.format(hotel.getMinPrice()));
        }

        ITourService tourService = new TourService();
        List<Tour> tours = tourService.getTopSixTours();
        for (Tour tour : tours) {
            tour.setFormattedMinPrice(currencyFormatter.format(tour.getForChildTotalPrice()));
            tour.setFormattedMaxPrice(currencyFormatter.format(tour.getTotalPrice()));
            System.out.println(tour.toString());

        }
        request.setAttribute("hotels", hotels);
        request.setAttribute("restaurants", restaurants);
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

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
