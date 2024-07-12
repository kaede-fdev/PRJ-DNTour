package service.interfaces;

import java.util.Date;
import java.util.List;
import model.Hotel;
import model.HotelImages;
import model.Restaurant;
import model.RestaurantImages;

/**
 *
 * @author VJames
 */
public interface IRestaurantSearch {

     List<Restaurant> getAllRestaurants();
    List<Restaurant> getRestaurantByCityAndStartdate(int cityId, Date startDate);
    List<RestaurantImages> getRestaurantImagesById(int restaurantId);
  
}
