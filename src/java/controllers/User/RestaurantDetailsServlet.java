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
import model.RestaurantImages;
import service.impl.RestaurantService;
import service.interfaces.IRestaurantService;
import utils.AppConstants;

/**
 *
 * @author VJames
 */
@WebServlet(name = "RestaurantDetailsServlet", urlPatterns = {"/restaurantdetails"})
public class RestaurantDetailsServlet extends HttpServlet {

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/User/restaurant-details-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Tour Details");
        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/User/Pages/restaurant-details.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (String) request.getParameter("id");
        NumberFormat currencyFormatter = NumberFormat.getInstance(new Locale("vi", "VN"));
        IRestaurantService restaurantService = new RestaurantService();
        Restaurant restaurant = restaurantService.getRestaurantById(Integer.parseInt(id));
        restaurant.setFormattedMinPrice(currencyFormatter.format(restaurant.getMinPrice()));
        restaurant.setFormattedMaxPrice(currencyFormatter.format(restaurant.getMaxPrice()));

        List<RestaurantImages> restaurantImageses = restaurantService.getAllRestaurantImagesesById(Integer.parseInt(id));
        request.setAttribute("restaurant", restaurant);
        request.setAttribute("restaurantImages", restaurantImageses);
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
