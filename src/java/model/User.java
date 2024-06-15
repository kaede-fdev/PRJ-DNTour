
import java.util.Date;

public class User {

    private String fullname;
    private String avatar;
    private String password;
    private String email;
    private String phone;
    private String budget;
    private Date createAt;
    private Date updateAt;

    public User(String fullname, String avatar, String password, String email, String phone, String budget, Date createAt, Date updateAt) {
        this.fullname = fullname;
        this.avatar = avatar;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.budget = budget;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public User() {
    }

    public String getFullname() {
        return fullname;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getBudget() {
        return budget;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "User{" + "fullname=" + fullname + ", avatar=" + avatar + ", password=" + password + ", email=" + email + ", phone=" + phone + ", budget=" + budget + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }

    //Builder
    private User(Builder builder) {
        this.fullname = builder.fullname;
        this.avatar = builder.avatar;
        this.password = builder.password;
        this.email = builder.email;
        this.phone = builder.phone;
        this.budget = builder.budget;
        this.createAt = builder.createAt;
        this.updateAt = builder.updateAt;
    }

    public static class Builder {

        private String fullname;
        private String avatar;
        private String password;
        private String email;
        private String phone;
        private String budget;
        private Date createAt;
        private Date updateAt;

        public Builder() {
        }

        public Builder fullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public Builder avatar(String avatar) {
            this.avatar = avatar;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder budget(String budget) {
            this.budget = budget;
            return this;
        }

        public Builder createAt(Date createAt) {
            this.createAt = createAt;
            return this;
        }

        public Builder updateAt(Date updateAt) {
            this.updateAt = updateAt;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
