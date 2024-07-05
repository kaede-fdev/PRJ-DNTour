package model;

import java.util.Date;

/**
 *
 * @author VJames
 */
public class HotelImages {

    private int Id;
    private int HotelId;
    private String Url;
    private Date createAt;
    private Date updateAt;

    public HotelImages(int Id, int HotelId, String Url, Date createAt, Date updateAt) {
        this.Id = Id;
        this.HotelId = HotelId;
        this.Url = Url;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public HotelImages() {
    }

    @Override
    public String toString() {
        return "HotelImages{" + "Id=" + Id + ", HotelId=" + HotelId + ", Url=" + Url + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setHotelId(int HotelId) {
        this.HotelId = HotelId;
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

    public int getHotelId() {
        return HotelId;
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
