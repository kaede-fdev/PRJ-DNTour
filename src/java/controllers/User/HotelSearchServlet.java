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
import java.util.List;
import java.util.Map;
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
import service.impl.HotelSearchService;
import utils.AppConstants;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "HotelSearchServlet", urlPatterns = {"/hotelsearch"})
public class HotelSearchServlet extends HttpServlet {

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/User/hotel-search-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Hotel Search");
        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/User/Pages/hotel-search.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//
//
//         System.out.println("abc");
//        // Forward the request to the JSP page
//        RequestDispatcher dispatcher = request.getRequestDispatcher("/Views/Modules/Pages/User/hotel-search-page.jsp");
//        dispatcher.forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Fetch all hotel data
        HotelSearchService hotelSearchService = new HotelSearchService();
        List<Hotel> hotels = hotelSearchService.getAllHotels();

        // Adjust prices and round them
        for (Hotel hotel : hotels) {
            hotel.setMinPrice(Math.round(hotel.getMinPrice() / 25000.0f));
            hotel.setMaxPrice(Math.round(hotel.getMaxPrice() / 25000.0f));
        }

        // Fetch images for each hotel and store them in a map
        Map<Integer, List<HotelImages>> hotelImagesMap = new HashMap<>();
        for (Hotel hotel : hotels) {
            List<HotelImages> images = hotelSearchService.getHotelImagesById(hotel.getId());
            hotelImagesMap.put(hotel.getId(), images);
        }

        // Set hotels and hotelImagesMap as session attributes
        HttpSession session = request.getSession();
        session.setAttribute("hotels", hotels);
        session.setAttribute("hotelImagesMap", hotelImagesMap);
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
                String rating1 = request.getParameter("1-start");
                String rating2 = request.getParameter("2-start");
                String rating3 = request.getParameter("3-start");
                String rating4 = request.getParameter("4-start");
                String rating5 = request.getParameter("5-start");

                List<Integer> star = new ArrayList<>();

                if (rating5 != null) {
                    star.add(5);
                }
                if (rating4 != null) {
                    star.add(4);
                }
                if (rating3 != null) {
                    star.add(3);
                }
                if (rating2 != null) {
                    star.add(2);
                }
                if (rating1 != null) {
                    star.add(1);
                }

                int min = Integer.parseInt(minInput);
                int max = Integer.parseInt(maxInput);
                String cityName = request.getParameter("city");
                String startDateStr = request.getParameter("start-date");

                // Retrieve the session
                HttpSession session = request.getSession();
                session.setAttribute("star", star);
                try {
                    List<Hotel> hotels;

                    // Check if cityName and startDateStr are provided
                    if (cityName == null || cityName.isEmpty() || startDateStr == null || startDateStr.isEmpty()) {
                        // Fetch all hotels if parameters are missing
                        HotelSearchService hotelSearchService = new HotelSearchService();
                        hotels = hotelSearchService.getAllHotels();
                        for (Hotel hotel : hotels) {
                            hotel.setMinPrice(Math.round(hotel.getMinPrice() / 25000.0f));
                            hotel.setMaxPrice(Math.round(hotel.getMaxPrice() / 25000.0f));
                        }
                    } else {
                        // Fetch hotels based on search form parameters
                        hotels = getHotelbyFormSearch(cityName, startDateStr);
                    }

                    session.setAttribute("hotels", hotels);

                } catch (ParseException | SQLException e) {
                    e.printStackTrace();
                    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }
                List<Hotel> hotels = (List<Hotel>) session.getAttribute("hotels");

                if (hotels == null) {
                    throw new ServletException("No hotels found in session");
                }

                if (star.size() != 0) {

                    List<Hotel> hotelsFileter = getListHotelbyValueAndStar(hotels, min, max, star);
                    session.setAttribute("hotels", hotelsFileter);
                } else {

                    List<Hotel> hotelsFileter = getListHotelbyValue(hotels, min, max);

                    session.setAttribute("hotels", hotelsFileter);
                }

                // Forward the request to the JSP page where you will display the filtered results
                renderPage(request, response);

            } catch (NumberFormatException | ServletException e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input parameters");
            }

        }
        if ("case-1".equals(action)) {
            System.out.println(action);
            String cityName = request.getParameter("city");
            String startDateStr = request.getParameter("start-date");

            // Call function to handle hotel search
            try {
                List<Hotel> hotels = getHotelbyFormSearch(cityName, startDateStr);

                // Set retrieved data as session attributes
                HttpSession session = request.getSession();
                session.setAttribute("hotels", hotels);
                session.setAttribute("cityName", cityName);

                LocalDate currentDate = LocalDate.now();

                // Set the date as a request attribute
                session.setAttribute("currentDate", currentDate);

                // Forward the request to the JSP page where you will display the results
                renderPage(request, response);
            } catch (ParseException | SQLException e) {
                e.printStackTrace();

                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
        }
    }

    private List<Hotel> getHotelbyFormSearch(String cityName, String startDateStr)
            throws ParseException, SQLException {

        // Convert startDateStr to Date object
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = dateFormat.parse(startDateStr);

        // Get city ID based on cityName (assuming you have a mapping)
        int cityId = mapCityToId(cityName);

        // Call service method to get hotels based on cityId and startDate
        HotelSearchService hotelSearchService = new HotelSearchService();
        System.out.println(startDate);
        List<Hotel> hotels = hotelSearchService.getHotelbyCityAndStartdate(cityId, startDate);

        // Round prices
        for (Hotel hotel : hotels) {
            hotel.setMinPrice(Math.round(hotel.getMinPrice() / 25000.0f));
            hotel.setMaxPrice(Math.round(hotel.getMaxPrice() / 25000.0f));
        }

        // Fetch images for each hotel and store them in a map
        Map<Integer, List<HotelImages>> hotelImagesMap = new HashMap<>();
        for (Hotel hotel : hotels) {
            List<HotelImages> images = hotelSearchService.getHotelImagesById(hotel.getId());
            hotelImagesMap.put(hotel.getId(), images);
        }

        // Optionally, you can set hotel images map as session attribute if needed
        // HttpSession session = request.getSession();
        // session.setAttribute("hotelImagesMap", hotelImagesMap);
        return hotels;
    }

    public List<Hotel> getListHotelbyValueAndStar(List<Hotel> arr, int min, int max, List<Integer> star) {
        List<Hotel> filteredHotels = new ArrayList<>();
        System.out.println(max);
        // Iterate through the list of hotel s
        for (Hotel hotel : arr) {
            // Check if hotel meets the price range criteria

            if (hotel.getMaxPrice() <= max) {

                if (star.contains(hotel.getStars())) {

                    filteredHotels.add(hotel);
                }
            }
        }

        return filteredHotels;
    }

    public List<Hotel> getListHotelbyValue(List<Hotel> arr, int min, int max) {
        List<Hotel> filteredHotels = new ArrayList<>();

        // Iterate through the list of hotels
        for (Hotel hotel : arr) {
            // Check if hotel meets the price range criteria
            if (hotel.getMaxPrice() <= max) {
                System.out.println(max);
                System.out.println(hotel.getMaxPrice());

                filteredHotels.add(hotel);

            }
        }

        return filteredHotels;
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
    }// </editor-fold>

}
