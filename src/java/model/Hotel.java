package model;

import java.util.Date;

/**
 *
 * @author VJames
 */
public class Hotel {

    private int Id;
    private int LocationId;
    private String Name;
    private int stars;
    private String Description;
    private String Address;
    private String OpenUrl;
    private String MapEmbed;
    private int MinPrice;
    private int MaxPrice;
    private Date createAt;
    private Date updateAt;

    private String FormattedMinPrice;
    private String FormattedMaxPrice;
    private String BackgroundImageUrl;

    public Hotel() {
    }

    @Override
    public String toString() {
        return "Hotel{" + "Id=" + Id + ", LocationId=" + LocationId + ", Name=" + Name + ", stars=" + stars + ", Description=" + Description + ", Address=" + Address + ", OpenUrl=" + OpenUrl + ", MapEmbed=" + MapEmbed + ", MinPrice=" + MinPrice + ", MaxPrice=" + MaxPrice + ", createAt=" + createAt + ", updateAt=" + updateAt + ", FormattedMinPrice=" + FormattedMinPrice + ", FormattedMaxPrice=" + FormattedMaxPrice + ", BackgroundImageUrl=" + BackgroundImageUrl + '}';
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setLocationId(int LocationId) {
        this.LocationId = LocationId;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setOpenUrl(String OpenUrl) {
        this.OpenUrl = OpenUrl;
    }

    public void setMapEmbed(String MapEmbed) {
        this.MapEmbed = MapEmbed;
    }

    public void setMinPrice(int MinPrice) {
        this.MinPrice = MinPrice;
    }

    public void setMaxPrice(int MaxPrice) {
        this.MaxPrice = MaxPrice;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public void setFormattedMinPrice(String FormattedMinPrice) {
        this.FormattedMinPrice = FormattedMinPrice;
    }

    public void setFormattedMaxPrice(String FormattedMaxPrice) {
        this.FormattedMaxPrice = FormattedMaxPrice;
    }

    public void setBackgroundImageUrl(String BackgroundImageUrl) {
        this.BackgroundImageUrl = BackgroundImageUrl;
    }

    public int getId() {
        return Id;
    }

    public int getLocationId() {
        return LocationId;
    }

    public String getName() {
        return Name;
    }

    public int getStars() {
        return stars;
    }

    public String getDescription() {
        return Description;
    }

    public String getAddress() {
        return Address;
    }

    public String getOpenUrl() {
        return OpenUrl;
    }

    public String getMapEmbed() {
        return MapEmbed;
    }

    public int getMinPrice() {
        return MinPrice;
    }

    public int getMaxPrice() {
        return MaxPrice;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public String getFormattedMinPrice() {
        return FormattedMinPrice;
    }

    public String getFormattedMaxPrice() {
        return FormattedMaxPrice;
    }

    public String getBackgroundImageUrl() {
        return BackgroundImageUrl;
    }

}
