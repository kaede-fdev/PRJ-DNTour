package service.interfaces;

import java.util.List;
import model.Hotel;
import model.HotelImages;
import model.Restaurant;
import model.RestaurantImages;

/**
 *
 * @author VJames
 */
public interface IHotelService {

    public List<Hotel> getTopFourHotels();

    public HotelImages getBackgroundImageById(int id);

    public List<Hotel> getAllHotels();

    public Hotel getHotelById(int id);

    public List<HotelImages> getAllHotelImagesesById(int id);
}
