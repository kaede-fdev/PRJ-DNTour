package service.impl;

import context.DatabaseContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Tour;
import model.TourImages;
import model.Tours;
import service.interfaces.ITourService;
import service.interfaces.IToursService;

/**
 *
 * @author VJames
 */
public class ToursService extends DatabaseContext implements IToursService {

    private final String getTopSixTourQuery = "SELECT * FROM SuGTours ORDER BY CreateAt DESC LIMIT 6";

    private final String getAllToursQuery = "SELECT * FROM SuGTours";

    private final String getTourByIdQuery = "SELECT * FROM SuGTours WHERE Id = ?";

    private final String getAllTourImagesQuery = "SELECT * FROM TourImages WHERE TourId = ?";
    private final String getToursByPriceQuery = "SELECT * FROM SuGTours WHERE TotalPrice > ?";

    @Override
    public List<Tours> getTopSixTours() {
        List<Tours> tours = new ArrayList<>();
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(getTopSixTourQuery);  ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Tours tour = new Tours();
                tour.setId(resultSet.getInt("Id"));
                tour.setHotelId(resultSet.getInt("HotelId"));
                tour.setRestaurantId(resultSet.getInt("RestaurantId")); // Add this line
                tour.setTitle(resultSet.getString("Title"));
                tour.setVehicle(resultSet.getString("Vehicle"));
                tour.setDuration(resultSet.getString("Duration"));
                tour.setStartDay(resultSet.getString("StartDay"));
                tour.setDescription(resultSet.getString("Description"));
                tour.setTotalPrice(resultSet.getInt("TotalPrice"));
                tour.setForChildTotalPrice(resultSet.getInt("ForChildTotalPrice"));
                tour.setBackgroundImage(resultSet.getString("BackgroundImage"));
                tour.setCreateAt(resultSet.getDate("CreateAt"));
                tour.setCpdateAt(resultSet.getDate("UpdateAt")); // Updated setter name
                tours.add(tour);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tours;
    }

    @Override
    public List<Tours> getAllTours() {
        List<Tours> tours = new ArrayList<>();
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(getAllToursQuery);  ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Tours tour = new Tours();
                tour.setId(resultSet.getInt("Id"));
                tour.setHotelId(resultSet.getInt("HotelId"));
                tour.setRestaurantId(resultSet.getInt("RestaurantId")); // Add this line
                tour.setTitle(resultSet.getString("Title"));
                tour.setVehicle(resultSet.getString("Vehicle"));
                tour.setDuration(resultSet.getString("Duration"));
                tour.setStartDay(resultSet.getString("StartDay"));
                tour.setDescription(resultSet.getString("Description"));
                tour.setTotalPrice(resultSet.getInt("TotalPrice"));
                tour.setForChildTotalPrice(resultSet.getInt("ForChildTotalPrice"));
                tour.setBackgroundImage(resultSet.getString("BackgroundImage"));
                tour.setCreateAt(resultSet.getDate("CreateAt"));
                tour.setCpdateAt(resultSet.getDate("UpdateAt")); // Updated setter name
                tours.add(tour);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tours;
    }

    @Override
    public Tours getTourById(int id) {
        Tours tour = null;
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(getTourByIdQuery)) {
            statement.setInt(1, id);
            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    tour = new Tours();
                    tour.setId(resultSet.getInt("Id"));
                    tour.setHotelId(resultSet.getInt("HotelId"));
                    tour.setRestaurantId(resultSet.getInt("RestaurantId")); // Add this line for RestaurantId
                    tour.setTitle(resultSet.getString("Title"));
                    tour.setVehicle(resultSet.getString("Vehicle"));
                    tour.setDuration(resultSet.getString("Duration"));
                    tour.setStartDay(resultSet.getString("StartDay"));
                    tour.setDescription(resultSet.getString("Description"));
                    tour.setTotalPrice(resultSet.getInt("TotalPrice"));
                    tour.setForChildTotalPrice(resultSet.getInt("ForChildTotalPrice"));
                    tour.setBackgroundImage(resultSet.getString("BackgroundImage"));
                    tour.setCreateAt(resultSet.getDate("CreateAt"));
                    tour.setCpdateAt(resultSet.getDate("UpdateAt")); // Updated setter name
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tour;
    }

    @Override
    public List<TourImages> getAllTourImagesById(int id) {
        List<TourImages> tourImagesList = new ArrayList<>();
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(getAllTourImagesQuery)) {

            statement.setInt(1, id);
            try ( ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    TourImages tourImage = new TourImages();
                    tourImage.setId(resultSet.getInt("Id"));
                    tourImage.setTourId(resultSet.getInt("TourId"));
                    tourImage.setUrl(resultSet.getString("Url"));
                    tourImage.setCreateAt(resultSet.getDate("CreateAt"));
                    tourImage.setUpdateAt(resultSet.getDate("UpdateAt"));
                    tourImagesList.add(tourImage);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tourImagesList;
    }

    public List<Tours> getToursByPrice(int price) {
        List<Tours> tours = new ArrayList<>();
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(getToursByPriceQuery)) {
            statement.setInt(1, price);
            try ( ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Tours tour = new Tours();
                    tour.setId(resultSet.getInt("Id"));
                    tour.setHotelId(resultSet.getInt("HotelId"));
                    tour.setRestaurantId(resultSet.getInt("RestaurantId"));
                    tour.setTitle(resultSet.getString("Title"));
                    tour.setVehicle(resultSet.getString("Vehicle"));
                    tour.setDuration(resultSet.getString("Duration"));
                    tour.setStartDay(resultSet.getString("StartDay"));
                    tour.setDescription(resultSet.getString("Description"));
                    tour.setTotalPrice(resultSet.getInt("TotalPrice"));
                    tour.setForChildTotalPrice(resultSet.getInt("ForChildTotalPrice"));
                    tour.setBackgroundImage(resultSet.getString("BackgroundImage"));
                    tour.setCreateAt(resultSet.getDate("CreateAt"));
                    tour.setCpdateAt(resultSet.getDate("UpdateAt")); // Updated setter name
                    tours.add(tour);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tours;
    }

}
