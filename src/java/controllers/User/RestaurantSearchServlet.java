/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Hotel;
import model.HotelImages;
import model.Restaurant;
import model.RestaurantImages;
import service.impl.HotelSearchService;
import service.impl.RestaurantSearchService;
import utils.AppConstants;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "RestaurantSearchServlet", urlPatterns = {"/restaurantsearch"})
public class RestaurantSearchServlet extends HttpServlet {

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/User/restaurant-search-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Tìm kiếm nhà hàng");
        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/User/Pages/restaurant-search.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fetch all restaurant data
        RestaurantSearchService restaurantSearchService = new RestaurantSearchService();
        List<Restaurant> restaurants = restaurantSearchService.getAllRestaurants();
        System.out.println(restaurants);
        // Adjust prices and round them
        for (Restaurant restaurant : restaurants) {
            restaurant.setMinPrice(Math.round(restaurant.getMinPrice() / 25000.0f));
            restaurant.setMaxPrice(Math.round(restaurant.getMaxPrice() / 25000.0f));
        }

        // Fetch images for each restaurant and store them in a map
        Map<Integer, List<RestaurantImages>> restaurantImagesMap = new HashMap<>();
        for (Restaurant restaurant : restaurants) {
            List<RestaurantImages> images = restaurantSearchService.getRestaurantImagesById(restaurant.getId());
            restaurantImagesMap.put(restaurant.getId(), images);
        }
        System.out.println(restaurantImagesMap);

        // Set restaurants and restaurantImagesMap as session attributes
        HttpSession session = request.getSession();
        session.setAttribute("restaurants", restaurants);
        session.setAttribute("restaurantImagesMap", restaurantImagesMap);

        // Forward to the JSP page
        renderPage(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        System.out.println(action);
        if ("case-2".equals(action)) {
            try {
                String minInput = request.getParameter("min-input");
                String maxInput = request.getParameter("max-input");

// Individual checkbox values
                String chinese = request.getParameter("chinese");
                String asian = request.getParameter("asian");
                String viet = request.getParameter("viet");
                String american = request.getParameter("american");
                String africa = request.getParameter("arfica");
                String italia = request.getParameter("italia");

                List<String> selectedCuisines = new ArrayList<>();
                if (chinese != null) {
                    selectedCuisines.add("Kiểu Trung Quốc");
                }
                if (asian != null) {
                    selectedCuisines.add("Kiểu Á");
                }
                if (viet != null) {
                    selectedCuisines.add("Kiểu Việt");
                }
                if (american != null) {
                    selectedCuisines.add("Kiểu Mỹ");
                }
                if (africa != null) {
                    selectedCuisines.add("Kiểu Âu");
                }
                if (italia != null) {
                    selectedCuisines.add("Kiểu Ý");
                }

                System.out.println(chinese + asian + viet + american + africa + italia);

                // System.out.println(selectedCuisines);
                int min = Integer.parseInt(minInput);
                int max = Integer.parseInt(maxInput);
                String cityName = request.getParameter("city");
                String startDateStr = request.getParameter("start-date");

                // Retrieve the session
                HttpSession session = request.getSession();
                try {
                    List<Restaurant> restaurants;

                    // Check if cityName and startDateStr are provided
                    if (cityName == null || cityName.isEmpty() || startDateStr == null || startDateStr.isEmpty()) {
                        // Fetch all restaurants if parameters are missing
                        RestaurantSearchService restaurantSearchService = new RestaurantSearchService();
                        restaurants = restaurantSearchService.getAllRestaurants();
                        for (Restaurant restaurant : restaurants) {
                            restaurant.setMinPrice(Math.round(restaurant.getMinPrice() / 25000.0f));
                            restaurant.setMaxPrice(Math.round(restaurant.getMaxPrice() / 25000.0f));
                        }

                    } else {
                        // Fetch restaurants based on search form parameters
                        restaurants = getRestaurantbyFormSearch(cityName, startDateStr);
                    }

                    // Set retrieved data as session attributes
                    session.setAttribute("restaurants", restaurants);

                    // Set current date as a session attribute
                    LocalDate currentDate = LocalDate.now();
                    session.setAttribute("currentDate", currentDate);

                } catch (ParseException | SQLException e) {
                    e.printStackTrace();
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
                List<Restaurant> restaurants = (List<Restaurant>) session.getAttribute("restaurants");

                if (restaurants == null) {
                    throw new ServletException("No restaurants found in session");
                }

                List<Restaurant> filteredRestaurants;
                if (!selectedCuisines.isEmpty()) {

                    filteredRestaurants = getListRestaurantbyValueAndStyle(restaurants, min, max, selectedCuisines);
                    session.setAttribute("restaurants", filteredRestaurants);
                } else {
                    filteredRestaurants = getListRestaurantbyValue(restaurants, min, max);
                    session.setAttribute("restaurants", filteredRestaurants);
                }

                // Forward the request to the JSP page where you will display the filtered results
                renderPage(request, response);

            } catch (NumberFormatException | ServletException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input parameters");
            }
        }

        if ("case-1".equals(action)) {
            String cityName = request.getParameter("city");
            String startDateStr = request.getParameter("start-date");
            System.out.println(cityName + "" + startDateStr);

            // Call function to handle restaurant search
            try {
                List<Restaurant> restaurants = getRestaurantbyFormSearch(cityName, startDateStr);

                // Set retrieved data as session attributes
                HttpSession session = request.getSession();
                session.setAttribute("restaurants", restaurants);
                session.setAttribute("cityName", cityName);
                LocalDate currentDate = LocalDate.now();
                session.setAttribute("currentDate", currentDate);

                // Forward the request to the JSP page where you will display the results
                renderPage(request, response);
            } catch (ParseException | SQLException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    private List<Restaurant> getRestaurantbyFormSearch(String cityName, String startDateStr)
            throws ParseException, SQLException {

        // Convert startDateStr to Date object
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse(startDateStr);

        // Get city ID based on cityName (assuming you have a mapping)
        int cityId = mapCityToId(cityName);

        // Call service method to get restaurants based on cityId and startDate
        RestaurantSearchService restaurantSearchService = new RestaurantSearchService();
        List<Restaurant> restaurants = restaurantSearchService.getRestaurantByCityAndStartdate(cityId, startDate);

        // Round prices
        for (Restaurant restaurant : restaurants) {
            restaurant.setMinPrice(Math.round(restaurant.getMinPrice() / 25000.0f));
            restaurant.setMaxPrice(Math.round(restaurant.getMaxPrice() / 25000.0f));
        }

        // Fetch images for each restaurant and store them in a map
        Map<Integer, List<RestaurantImages>> restaurantImagesMap = new HashMap<>();
        for (Restaurant restaurant : restaurants) {
            List<RestaurantImages> images = restaurantSearchService.getRestaurantImagesById(restaurant.getId());
            restaurantImagesMap.put(restaurant.getId(), images);
        }

        return restaurants;
    }

    public List<Restaurant> getListRestaurantbyValueAndStyle(List<Restaurant> arr, int min, int max, List<String> selectedCuisines) {
        Set<Restaurant> filteredRestaurants = new HashSet<>();

        for (Restaurant restaurant : arr) {
            if (restaurant.getMaxPrice() <= max && restaurant.getMaxPrice() >= min) {
                boolean cuisineMatched = false;
                for (String cuisine : selectedCuisines) {
                    if (restaurant.getStyles().contains(cuisine)) {
                        cuisineMatched = true;
                        break;
                    }
                }
                if (cuisineMatched) {
                    filteredRestaurants.add(restaurant);
                }
            }
        }

        return new ArrayList<>(filteredRestaurants);
    }

    public List<Restaurant> getListRestaurantbyValue(List<Restaurant> arr, int min, int max) {
        List<Restaurant> filteredRestaurants = new ArrayList<>();

        for (Restaurant restaurant : arr) {
            if (restaurant.getMaxPrice() <= max) {
                filteredRestaurants.add(restaurant);
            }
        }

        return filteredRestaurants;
    }

    // Method to map city names to IDs
    private int mapCityToId(String cityName) {
        switch (cityName) {
            case "Da Nang":
                return 1;
            case "Hue":
                return 2;
            case "Hoi An":
                return 3;
            default:
                return 0; // or handle unknown city
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
