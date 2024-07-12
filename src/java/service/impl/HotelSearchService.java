/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import context.DatabaseContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Hotel;
import model.HotelImages;
import service.interfaces.IHotelSearch;
import service.interfaces.IHotelService;

/**
 *
 * @author ADMIN
 */
public class HotelSearchService extends DatabaseContext implements IHotelSearch {

    private static final String getAllHotelsQuery = "SELECT * FROM Hotels";
    private static final String getHotelByCityAndStartDateQuery
            = "SELECT * FROM Hotels WHERE LocationId = ? AND createAt <= ? ";
    private static final String getHotelImagesByIdQuery = "SELECT * FROM HotelImages WHERE HotelId = ?";

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(getAllHotelsQuery)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(resultSet.getInt("Id"));
                hotel.setLocationId(resultSet.getInt("LocationId"));
                hotel.setName(resultSet.getString("Name"));
                hotel.setStars(resultSet.getInt("stars"));
                hotel.setDescription(resultSet.getString("Description"));
                hotel.setAddress(resultSet.getString("Address"));
                hotel.setOpenUrl(resultSet.getString("OpenUrl"));
                hotel.setMapEmbed(resultSet.getString("MapEmbed"));
                hotel.setMinPrice(resultSet.getInt("MinPrice"));
                hotel.setMaxPrice(resultSet.getInt("MaxPrice"));
                hotel.setCreateAt(resultSet.getTimestamp("createAt"));
                hotel.setUpdateAt(resultSet.getTimestamp("updateAt"));
                hotels.add(hotel);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hotels;
    }

   

    @Override
    public List<HotelImages> getHotelImagesById(int hotelId) {
        List<HotelImages> images = new ArrayList<>();
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(getHotelImagesByIdQuery)) {
            statement.setInt(1, hotelId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HotelImages image = new HotelImages();
                image.setId(resultSet.getInt("Id"));
                image.setHotelId(resultSet.getInt("HotelId"));
                image.setUrl(resultSet.getString("Url"));
                image.setCreateAt(resultSet.getTimestamp("createAt"));
                image.setUpdateAt(resultSet.getTimestamp("updateAt"));
                images.add(image);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return images;
    }

    @Override
    public List<Hotel> getHotelbyCityAndStartdate(int cityId, Date startDate) {
        List<Hotel> hotels = new ArrayList<>();
        try ( Connection connection = getConnection();  PreparedStatement statement = connection.prepareStatement(getHotelByCityAndStartDateQuery)) {
            statement.setInt(1, cityId);
            statement.setTimestamp(2, new java.sql.Timestamp(startDate.getTime()));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Hotel hotel = new Hotel();
                hotel.setId(resultSet.getInt("Id"));
                hotel.setLocationId(resultSet.getInt("LocationId"));
                hotel.setName(resultSet.getString("Name"));
                hotel.setStars(resultSet.getInt("stars"));
                hotel.setDescription(resultSet.getString("Description"));
                hotel.setAddress(resultSet.getString("Address"));
                hotel.setOpenUrl(resultSet.getString("OpenUrl"));
                hotel.setMapEmbed(resultSet.getString("MapEmbed"));
                hotel.setMinPrice(resultSet.getInt("MinPrice"));
                hotel.setMaxPrice(resultSet.getInt("MaxPrice"));
                hotel.setCreateAt(resultSet.getTimestamp("createAt"));
                hotel.setUpdateAt(resultSet.getTimestamp("updateAt"));
                hotels.add(hotel);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hotels;
    }

//    @Override
//    public List<Hotel> getListHotelbyValueAndStar(List<Hotel> arr, int min, int max, List<Integer> star) {
//               List<Hotel> filteredHotels = new ArrayList<>();
//
//        // Iterate through the list of hotels
//        for (Hotel hotel : arr) {
//            // Check if hotel meets the price range criteria
//            if (hotel.getMinPrice() >= min && hotel.getMaxPrice() <= max) {
//               
//                if (star.contains(hotel.getStars())) {
//                   
//                    filteredHotels.add(hotel);
//                }
//            }
//        }
//
//        return filteredHotels;
//    }
}
