package service.interfaces;

import java.util.List;
import model.Tour;
import model.TourImages;

/**
 *
 * @author VJames
 */
public interface ITourService {

    public List<Tour> getTopSixTours();

    public List<Tour> getAllTours();

    public Tour getTourById(int id);

    public List<TourImages> getAllTourImagesById(int id);
}
