package service.interfaces;

import java.util.Date;
import java.util.List;
import model.Hotel;
import model.HotelImages;

/**
 *
 * @author VJames
 */
public interface IHotelSearch {

    public List<Hotel> getAllHotels();

    public List<Hotel> getHotelbyCityAndStartdate(int cityId, Date startDate);

    public List<HotelImages> getHotelImagesById(int hotelId);

}
