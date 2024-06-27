package model;

import java.util.Date;

public class User {

    private String id;
    private String fullname;
    private String avatar;
    private String password;
    private String email;
    private String phone;
    private String budget;
    private String role;
    private boolean verify;
    private Date createAt;
    private Date updateAt;

    public User(String id, String fullname, String avatar, String password, String email, String phone, String budget, String role, boolean verify, Date createAt, Date updateAt) {
        this.id = id;
        this.fullname = fullname;
        this.avatar = avatar;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.budget = budget;
        this.role = role;
        this.verify = verify;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public User() {
    }

    public String getId() {
        return id;
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

    public String getRole() {
        return role;
    }

    public boolean isVerify() {
        return verify;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setId(String id) {
        this.id = id;
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

    public void setRole(String role) {
        this.role = role;
    }

    public void setVerify(boolean verify) {
        this.verify = verify;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", fullname=" + fullname + ", avatar=" + avatar + ", password=" + password + ", email=" + email + ", phone=" + phone + ", budget=" + budget + ", role=" + role + ", verify=" + verify + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }

    //Builder
    private User(Builder builder) {
        this.id = builder.id;
        this.fullname = builder.fullname;
        this.avatar = builder.avatar;
        this.password = builder.password;
        this.email = builder.email;
        this.phone = builder.phone;
        this.budget = builder.budget;
        this.role = builder.role;
        this.verify = builder.verify;
        this.createAt = builder.createAt;
        this.updateAt = builder.updateAt;
    }

    public static class Builder {

        private String id;
        private String fullname;
        private String avatar;
        private String password;
        private String email;
        private String phone;
        private String budget;
        private String role;
        private boolean verify;
        private Date createAt;
        private Date updateAt;

        public Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
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

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder verify(boolean verify) {
            this.verify = verify;
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
