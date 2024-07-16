package service.interfaces;

import java.util.List;
import model.Tour;
import model.TourImages;
import model.Tours;

/**
 *
 * @author VJames
 */
public interface IToursService {

    public List<Tours> getTopSixTours();

    public List<Tours> getAllTours();

    public Tours getTourById(int id);
    public List<Tours> getToursByPrice(int price);
    public List<TourImages> getAllTourImagesById(int id);
}
