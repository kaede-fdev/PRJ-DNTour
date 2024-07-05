package model;

import java.util.Date;

/**
 *
 * @author VJames
 */
public class RestaurantImages {

    private int Id;
    private int RestaurantId;
    private String Url;
    private Date createAt;
    private Date updateAt;

    public RestaurantImages(int Id, int RestaurantId, String Url, Date createAt, Date updateAt) {
        this.Id = Id;
        this.RestaurantId = RestaurantId;
        this.Url = Url;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public RestaurantImages() {
    }

    @Override
    public String toString() {
        return "RestaurantImages{" + "Id=" + Id + ", RestaurantId=" + RestaurantId + ", Url=" + Url + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setRestaurantId(int RestaurantId) {
        this.RestaurantId = RestaurantId;
    }

    public void setUrl(String Url) {
        this.Url = Url;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getId() {
        return Id;
    }

    public int getRestaurantId() {
        return RestaurantId;
    }

    public String getUrl() {
        return Url;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

}
