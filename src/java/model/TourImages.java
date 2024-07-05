package model;

import java.util.Date;

/**
 *
 * @author VJames
 */
public class TourImages {

    private int Id;
    private int TourId;
    private String Url;
    private Date createAt;
    private Date updateAt;

    public TourImages() {
    }

    public TourImages(int Id, int TourId, String Url, Date createAt, Date updateAt) {
        this.Id = Id;
        this.TourId = TourId;
        this.Url = Url;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "TourImages{" + "Id=" + Id + ", TourId=" + TourId + ", Url=" + Url + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setTourId(int TourId) {
        this.TourId = TourId;
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

    public int getTourId() {
        return TourId;
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
