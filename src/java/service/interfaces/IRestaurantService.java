package service.interfaces;

import java.util.List;
import model.Restaurant;
import model.RestaurantImages;

/**
 *
 * @author VJames
 */
public interface IRestaurantService {

    public List<Restaurant> getTopThreeRestaurant();

    public RestaurantImages getBackgroundImageById(int id);

    public List<Restaurant> getAllRestaurants();

    public Restaurant getRestaurantById(int id);

    public List<RestaurantImages> getAllRestaurantImagesesById(int id);
}
