package service.impl;

import context.DatabaseContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Hotel;
import model.HotelImages;
import service.interfaces.IHotelService;

/**
 *
 * @author VJames
 */
public class HotelService extends DatabaseContext implements IHotelService {

    private final String getTopFourHotelsQuery = "SELECT TOP 4 * FROM Hotels ORDER BY CreateAt DESC";
    private final String getBackgroundImageByIdQuery = "SELECT TOP 1 * FROM HotelImages WHERE HotelId = ?";
    private final String getAllHotelsQuery = "SELECT * FROM Hotels";
    private final String getHotelByIdQuery = "SELECT * FROM Hotels WHERE Id = ?";
    private final String getAllHotelImagesByIdQuery = "SELECT * FROM HotelImages WHERE HotelId = ?";

    @Override
    public List<Hotel> getTopFourHotels() {
        List<Hotel> hotels = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getTopFourHotelsQuery)) {
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
    public HotelImages getBackgroundImageById(int id) {
        HotelImages hotelImage = null;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getBackgroundImageByIdQuery)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                hotelImage = new HotelImages();
                hotelImage.setId(resultSet.getInt("Id"));
                hotelImage.setHotelId(resultSet.getInt("HotelId"));
                hotelImage.setUrl(resultSet.getString("Url"));
                hotelImage.setCreateAt(resultSet.getTimestamp("CreateAt"));
                hotelImage.setUpdateAt(resultSet.getTimestamp("UpdateAt"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hotelImage;
    }

    @Override
    public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getAllHotelsQuery)) {
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
    public Hotel getHotelById(int id) {
        Hotel hotel = null;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getHotelByIdQuery)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                hotel = new Hotel();
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

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hotel;
    }

    @Override
    public List<HotelImages> getAllHotelImagesesById(int id) {
        List<HotelImages> hotelImagesList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getAllHotelImagesByIdQuery)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                HotelImages hotelImage = new HotelImages();
                hotelImage.setId(resultSet.getInt("Id"));
                hotelImage.setHotelId(resultSet.getInt("HotelId"));
                hotelImage.setUrl(resultSet.getString("Url"));
                hotelImage.setCreateAt(resultSet.getTimestamp("CreateAt"));
                hotelImage.setUpdateAt(resultSet.getTimestamp("UpdateAt"));
                hotelImagesList.add(hotelImage);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hotelImagesList;
    }

}
