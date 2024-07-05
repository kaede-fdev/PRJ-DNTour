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
import service.interfaces.ITourService;

/**
 *
 * @author VJames
 */
public class TourService extends DatabaseContext implements ITourService {

    private final String getTopSixTourQuery = "SELECT TOP 6 * FROM Tours ORDER BY CreateAt DESC";
    private final String getAllToursQuery = "SELECT * FROM Tours";
    private final String getTourByIdQuery = "SELECT * FROM Tours WHERE Id = ?";
    private final String getAllTourImagesQuery = "SELECT * FROM TourImages WHERE TourId = ?";

    @Override
    public List<Tour> getTopSixTours() {
        List<Tour> tours = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getTopSixTourQuery); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Tour tour = new Tour();
                tour.setId(resultSet.getInt("Id"));
                tour.setHotelId(resultSet.getInt("HotelId"));
                tour.setTitle(resultSet.getString("Title"));
                tour.setVehicle(resultSet.getString("Vehicle"));
                tour.setDuration(resultSet.getString("Duration"));
                tour.setStartDay(resultSet.getString("StartDay"));
                tour.setDescription(resultSet.getString("Description"));
                tour.setTotalPrice(resultSet.getInt("TotalPrice"));
                tour.setForChildTotalPrice(resultSet.getInt("ForChildTotalPrice"));
                tour.setBackgroundImage(resultSet.getString("BackgroundImage"));
                tour.setCreateAt(resultSet.getDate("CreateAt"));
                tour.setCpdateAt(resultSet.getDate("UpdateAt"));
                tours.add(tour);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tours;
    }

    @Override
    public List<Tour> getAllTours() {
        List<Tour> tours = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getAllToursQuery); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Tour tour = new Tour();
                tour.setId(resultSet.getInt("Id"));
                tour.setHotelId(resultSet.getInt("HotelId"));
                tour.setTitle(resultSet.getString("Title"));
                tour.setVehicle(resultSet.getString("Vehicle"));
                tour.setDuration(resultSet.getString("Duration"));
                tour.setStartDay(resultSet.getString("StartDay"));
                tour.setDescription(resultSet.getString("Description"));
                tour.setTotalPrice(resultSet.getInt("TotalPrice"));
                tour.setForChildTotalPrice(resultSet.getInt("ForChildTotalPrice"));
                tour.setBackgroundImage(resultSet.getString("BackgroundImage"));
                tour.setCreateAt(resultSet.getDate("CreateAt"));
                tour.setCpdateAt(resultSet.getDate("UpdateAt"));
                tours.add(tour);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tours;
    }

    @Override
    public Tour getTourById(int id) {
        Tour tour = null;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getTourByIdQuery)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    tour = new Tour();
                    tour.setId(resultSet.getInt("Id"));
                    tour.setHotelId(resultSet.getInt("HotelId"));
                    tour.setTitle(resultSet.getString("Title"));
                    tour.setVehicle(resultSet.getString("Vehicle"));
                    tour.setDuration(resultSet.getString("Duration"));
                    tour.setStartDay(resultSet.getString("StartDay"));
                    tour.setDescription(resultSet.getString("Description"));
                    tour.setTotalPrice(resultSet.getInt("TotalPrice"));
                    tour.setForChildTotalPrice(resultSet.getInt("ForChildTotalPrice"));
                    tour.setBackgroundImage(resultSet.getString("BackgroundImage"));
                    tour.setCreateAt(resultSet.getDate("CreateAt"));
                    tour.setCpdateAt(resultSet.getDate("UpdateAt"));
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
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getAllTourImagesQuery)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
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
}
