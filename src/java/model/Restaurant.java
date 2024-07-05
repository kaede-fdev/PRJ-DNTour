package model;

import java.util.*;

/**
 *
 * @author VJames
 */
public class Restaurant {

    private int Id;
    private int LocationId;
    private String Name;
    private String Styles;
    private String Address;
    private String OpenUrl;
    private String MapEmbed;
    private String backgroundImageUrl;
    private int MinPrice;
    private int MaxPrice;
    private Date createAt;
    private Date updateAt;

    private String formattedMinPrice;
    private String formattedMaxPrice;

    public Restaurant() {
    }

    public Restaurant(int Id, int LocationId, String Name, String Styles, String Address, String OpenUrl, String MapEmbed, int MinPrice, int MaxPrice, Date createAt, Date updateAt) {
        this.Id = Id;
        this.LocationId = LocationId;
        this.Name = Name;
        this.Styles = Styles;
        this.Address = Address;
        this.OpenUrl = OpenUrl;
        this.MapEmbed = MapEmbed;
        this.MinPrice = MinPrice;
        this.MaxPrice = MaxPrice;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public String getFormattedMinPrice() {
        return formattedMinPrice;
    }

    public void setFormattedMinPrice(String formattedMinPrice) {
        this.formattedMinPrice = formattedMinPrice;
    }

    public String getFormattedMaxPrice() {
        return formattedMaxPrice;
    }

    public void setFormattedMaxPrice(String formattedMaxPrice) {
        this.formattedMaxPrice = formattedMaxPrice;
    }

    public String getBackgroundImageUrl() {
        return backgroundImageUrl;
    }

    public void setBackgroundImageUrl(String backgroundImageUrl) {
        this.backgroundImageUrl = backgroundImageUrl;
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

    public String getStyles() {
        return Styles;
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

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setLocationId(int LocationId) {
        this.LocationId = LocationId;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setStyles(String Styles) {
        this.Styles = Styles;
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

    @Override
    public String toString() {
        return "Restaurant{" + "Id=" + Id + ", LocationId=" + LocationId + ", Name=" + Name + ", Styles=" + Styles + ", Address=" + Address + ", OpenUrl=" + OpenUrl + ", MapEmbed=" + MapEmbed + ", MinPrice=" + MinPrice + ", MaxPrice=" + MaxPrice + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }

}
