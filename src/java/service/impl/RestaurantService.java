package service.impl;

import java.util.List;
import model.Restaurant;
import model.RestaurantImages;
import service.interfaces.IRestaurantService;
import context.DatabaseContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author VJames
 */
public class RestaurantService extends DatabaseContext implements IRestaurantService {

    private final String getTopThreeRestaurantQuery = "SELECT TOP 3 * FROM Restaurants ORDER BY CreateAt DESC";
    private final String getBackgroundImageByIdQuery = "SELECT TOP 1 * FROM RestaurantImages WHERE RestaurantId = ?";
    private final String getAllRestaurantsQuery = "SELECT * FROM Restaurants";
    private final String getAllRestaurantImagesQuery = "SELECT * FROM RestaurantImages WHERE RestaurantId = ?";
    private final String getRestaurantByIdQuery = "SELECT * FROM Restaurants WHERE Id = ?";

    @Override

    public List<Restaurant> getTopThreeRestaurant() {
        List<Restaurant> restaurants = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getTopThreeRestaurantQuery)) {
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
                restaurant.setCreateAt(resultSet.getTimestamp("CreateAt"));
                restaurant.setUpdateAt(resultSet.getTimestamp("UpdateAt"));
                restaurants.add(restaurant);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return restaurants;
    }

    @Override
    public RestaurantImages getBackgroundImageById(int id) {
        RestaurantImages restaurantImage = null;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getBackgroundImageByIdQuery)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                restaurantImage = new RestaurantImages();
                restaurantImage.setId(resultSet.getInt("Id"));
                restaurantImage.setRestaurantId(resultSet.getInt("RestaurantId"));
                restaurantImage.setUrl(resultSet.getString("Url"));
                restaurantImage.setCreateAt(resultSet.getTimestamp("CreateAt"));
                restaurantImage.setUpdateAt(resultSet.getTimestamp("UpdateAt"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return restaurantImage;
    }

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
                restaurant.setCreateAt(resultSet.getTimestamp("CreateAt"));
                restaurant.setUpdateAt(resultSet.getTimestamp("UpdateAt"));
                restaurants.add(restaurant);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return restaurants;
    }

    @Override
    public List<RestaurantImages> getAllRestaurantImagesesById(int id) {
        List<RestaurantImages> restaurantImagesList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getAllRestaurantImagesQuery)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                RestaurantImages restaurantImage = new RestaurantImages();
                restaurantImage.setId(resultSet.getInt("Id"));
                restaurantImage.setRestaurantId(resultSet.getInt("RestaurantId"));
                restaurantImage.setUrl(resultSet.getString("Url"));
                restaurantImage.setCreateAt(resultSet.getTimestamp("CreateAt"));
                restaurantImage.setUpdateAt(resultSet.getTimestamp("UpdateAt"));
                restaurantImagesList.add(restaurantImage);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return restaurantImagesList;
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        Restaurant restaurant = null;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(getRestaurantByIdQuery)) {
            statement.setInt(1, id);
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

}
