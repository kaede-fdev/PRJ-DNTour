package service.impl;

import context.DatabaseContext;
import static context.DatabaseContext.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Restaurant;
import model.RestaurantImages;
import service.interfaces.IRestaurantSearch;

public class RestaurantSearchService extends DatabaseContext implements IRestaurantSearch {

    private static final String getAllRestaurantsQuery = "SELECT * FROM Restaurants";
    private static final String getRestaurantByCityAndStartDateQuery = "SELECT * FROM Restaurants WHERE LocationId = ? AND createAt <= ?";
    private static final String getRestaurantImagesByIdQuery = "SELECT * FROM RestaurantImages WHERE RestaurantId = ?";
    private static final String getRestaurantByIdQuery = "SELECT * FROM Restaurants WHERE Id = ?";
    private final String getRestaurantByMinPriceQuery = "SELECT * FROM Restaurants WHERE MinPrice = ? ";

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getAllRestaurantsQuery)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt("Id"));
                restaurant.setLocationId(resultSet.getInt("LocationId"));
                restaurant.setName(resultSet.getString("Name"));
                restaurant.setStyles(resultSet.getString("Styles"));
                restaurant.setAddress(resultSet.getString("Address"));
                restaurant.setOpenUrl(resultSet.getString("OpenUrl"));
                restaurant.setMapEmbed(resultSet.getString("MapEmbed"));

                restaurant.setMinPrice(resultSet.getInt("MinPrice"));
                restaurant.setMaxPrice(resultSet.getInt("MaxPrice"));
                restaurant.setCreateAt(resultSet.getDate("CreateAt"));
                restaurant.setUpdateAt(resultSet.getDate("UpdateAt"));
                restaurants.add(restaurant);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return restaurants;
    }

    @Override
    public List<RestaurantImages> getRestaurantImagesById(int restaurantId) {
        List<RestaurantImages> images = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getRestaurantImagesByIdQuery)) {
            statement.setInt(1, restaurantId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                RestaurantImages image = new RestaurantImages();
                image.setId(resultSet.getInt("Id"));
                image.setRestaurantId(resultSet.getInt("RestaurantId"));
                image.setUrl(resultSet.getString("Url"));
                image.setCreateAt(resultSet.getDate("CreateAt"));
                image.setUpdateAt(resultSet.getDate("UpdateAt"));
                images.add(image);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return images;
    }

    @Override
    public List<Restaurant> getRestaurantByCityAndStartdate(int cityId, Date startDate) {
        List<Restaurant> restaurants = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getRestaurantByCityAndStartDateQuery)) {
            statement.setInt(1, cityId);
            statement.setDate(2, new java.sql.Date(startDate.getTime()));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt("Id"));
                restaurant.setLocationId(resultSet.getInt("LocationId"));
                restaurant.setName(resultSet.getString("Name"));
                restaurant.setStyles(resultSet.getString("Styles"));
                restaurant.setAddress(resultSet.getString("Address"));
                restaurant.setOpenUrl(resultSet.getString("OpenUrl"));
                restaurant.setMapEmbed(resultSet.getString("MapEmbed"));

                restaurant.setMinPrice(resultSet.getInt("MinPrice"));
                restaurant.setMaxPrice(resultSet.getInt("MaxPrice"));
                restaurant.setCreateAt(resultSet.getDate("CreateAt"));
                restaurant.setUpdateAt(resultSet.getDate("UpdateAt"));
                restaurants.add(restaurant);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return restaurants;
    }

    @Override
    public Restaurant getRestaurantByMinPrice(int minPrice) {
        Restaurant restaurant = null;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getRestaurantByMinPriceQuery)) {

            statement.setInt(1, minPrice); // Set the parameter for MinPrice

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt("Id"));
                restaurant.setLocationId(resultSet.getInt("LocationId"));
                restaurant.setName(resultSet.getString("Name"));
                restaurant.setStyles(resultSet.getString("Styles"));
                restaurant.setAddress(resultSet.getString("Address"));
                restaurant.setOpenUrl(resultSet.getString("OpenUrl"));
                restaurant.setMapEmbed(resultSet.getString("MapEmbed"));
                restaurant.setMinPrice(resultSet.getInt("MinPrice"));
                restaurant.setMaxPrice(resultSet.getInt("MaxPrice"));
                restaurant.setCreateAt(resultSet.getTimestamp("CreateAt"));
                restaurant.setUpdateAt(resultSet.getTimestamp("UpdateAt"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        Restaurant restaurant = null;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getRestaurantByIdQuery)) {
            statement.setInt(1, restaurantId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                restaurant = new Restaurant();
                restaurant.setId(resultSet.getInt("Id"));
                restaurant.setLocationId(resultSet.getInt("LocationId"));
                restaurant.setName(resultSet.getString("Name"));
                restaurant.setStyles(resultSet.getString("Styles"));
                restaurant.setAddress(resultSet.getString("Address"));
                restaurant.setOpenUrl(resultSet.getString("OpenUrl"));
                restaurant.setMapEmbed(resultSet.getString("MapEmbed"));
                restaurant.setMinPrice(resultSet.getInt("MinPrice"));
                restaurant.setMaxPrice(resultSet.getInt("MaxPrice"));
                restaurant.setCreateAt(resultSet.getDate("CreateAt"));
                restaurant.setUpdateAt(resultSet.getDate("UpdateAt"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return restaurant;
    }

}
