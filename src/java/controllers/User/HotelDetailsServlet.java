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
import model.Hotel;
import model.HotelImages;
import service.impl.HotelService;
import service.interfaces.IHotelService;
import utils.AppConstants;

/**
 *
 * @author VJames
 */
@WebServlet(name = "HotelDetailsServlet", urlPatterns = {"/hoteldetails"})
public class HotelDetailsServlet extends HttpServlet {

    private void renderPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("pageContent", AppConstants.AppViewsModulesPrefix + "/Pages/User/hotel-details-page.jsp");
        request.setAttribute("pageTitle", "DNTour - Tour Details");
        request.getRequestDispatcher(AppConstants.AppViewsPrefix + "/User/Pages/hotel-details.jsp").forward(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (String) request.getParameter("id");
        NumberFormat currencyFormatter = NumberFormat.getInstance(new Locale("vi", "VN"));
        IHotelService hotelService = new HotelService();
        Hotel hotel = hotelService.getHotelById(Integer.parseInt(id));

        System.out.println(hotel);
        hotel.setFormattedMaxPrice(currencyFormatter.format(hotel.getMaxPrice()));
        hotel.setFormattedMinPrice(currencyFormatter.format(hotel.getMinPrice()));

        List<HotelImages> hotelImages = hotelService.getAllHotelImagesesById(Integer.parseInt(id));
        request.setAttribute("hotel", hotel);
        request.setAttribute("hotelImages", hotelImages);
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
