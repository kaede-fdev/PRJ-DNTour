package model;

import java.util.*;

/**
 *
 * @author VJames
 */
public class Tour {

    private int Id;
    private int HotelId;
    private String Title;
    private String Vehicle;
    private String Duration;
    private String StartDay;
    private String Description;
    private int TotalPrice;
    private int ForChildTotalPrice;
    private String BackgroundImage;
    private Date CreateAt;
    private Date CpdateAt;

    private String FormattedMinPrice;
    private String FormattedMaxPrice;

    public Tour() {
    }

    public Tour(int Id, int HotelId, String Title, String Vehicle, String Duration, String StartDay, String Description, int TotalPrice, int ForChildTotalPrice, String BackgroundImage, Date CreateAt, Date CpdateAt) {
        this.Id = Id;
        this.HotelId = HotelId;
        this.Title = Title;
        this.Vehicle = Vehicle;
        this.Duration = Duration;
        this.StartDay = StartDay;
        this.Description = Description;
        this.TotalPrice = TotalPrice;
        this.ForChildTotalPrice = ForChildTotalPrice;
        this.BackgroundImage = BackgroundImage;
        this.CreateAt = CreateAt;
        this.CpdateAt = CpdateAt;
    }

    @Override
    public String toString() {
        return "Tour{" + "Id=" + Id + ", HotelId=" + HotelId + ", Title=" + Title + ", Vehicle=" + Vehicle + ", Duration=" + Duration + ", StartDay=" + StartDay + ", Description=" + Description + ", TotalPrice=" + TotalPrice + ", ForChildTotalPrice=" + ForChildTotalPrice + ", BackgroundImage=" + BackgroundImage + ", CreateAt=" + CreateAt + ", CpdateAt=" + CpdateAt + ", FormattedMinPrice=" + FormattedMinPrice + ", FormattedMaxPrice=" + FormattedMaxPrice + '}';
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setHotelId(int HotelId) {
        this.HotelId = HotelId;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setVehicle(String Vehicle) {
        this.Vehicle = Vehicle;
    }

    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    public void setStartDay(String StartDay) {
        this.StartDay = StartDay;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setTotalPrice(int TotalPrice) {
        this.TotalPrice = TotalPrice;
    }

    public void setForChildTotalPrice(int ForChildTotalPrice) {
        this.ForChildTotalPrice = ForChildTotalPrice;
    }

    public void setBackgroundImage(String BackgroundImage) {
        this.BackgroundImage = BackgroundImage;
    }

    public void setCreateAt(Date CreateAt) {
        this.CreateAt = CreateAt;
    }

    public void setCpdateAt(Date CpdateAt) {
        this.CpdateAt = CpdateAt;
    }

    public void setFormattedMinPrice(String FormattedMinPrice) {
        this.FormattedMinPrice = FormattedMinPrice;
    }

    public void setFormattedMaxPrice(String FormattedMaxPrice) {
        this.FormattedMaxPrice = FormattedMaxPrice;
    }

    public int getId() {
        return Id;
    }

    public int getHotelId() {
        return HotelId;
    }

    public String getTitle() {
        return Title;
    }

    public String getVehicle() {
        return Vehicle;
    }

    public String getDuration() {
        return Duration;
    }

    public String getStartDay() {
        return StartDay;
    }

    public String getDescription() {
        return Description;
    }

    public int getTotalPrice() {
        return TotalPrice;
    }

    public int getForChildTotalPrice() {
        return ForChildTotalPrice;
    }

    public String getBackgroundImage() {
        return BackgroundImage;
    }

    public Date getCreateAt() {
        return CreateAt;
    }

    public Date getCpdateAt() {
        return CpdateAt;
    }

    public String getFormattedMinPrice() {
        return FormattedMinPrice;
    }

    public String getFormattedMaxPrice() {
        return FormattedMaxPrice;
    }

}
