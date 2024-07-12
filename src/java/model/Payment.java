package model;

import java.util.Date;

/**
 *
 * @author VJames
 */
public class Payment {

    private int id;
    private int tourId;
    private String userId;
    private String fullname;
    private String phone;
    private String email;
    private String address;
    private int amount;
    private String paymentCode;
    private boolean isPaid;
    private Date createAt;
    private Date updateAt;

    public Payment() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPaymentCode(String paymentCode) {
        this.paymentCode = paymentCode;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public int getId() {
        return id;
    }

    public int getTourId() {
        return tourId;
    }

    public String getUserId() {
        return userId;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getAmount() {
        return amount;
    }

    public String getPaymentCode() {
        return paymentCode;
    }

    public boolean isIsPaid() {
        return isPaid;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

}
