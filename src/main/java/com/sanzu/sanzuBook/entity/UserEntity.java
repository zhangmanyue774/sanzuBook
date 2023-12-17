package com.sanzu.sanzuBook.entity;

public class UserEntity {
    private Integer id;
    private String account;
    private String username;
    private String password;
    private String avatar;
    private Boolean isAdmin;
    private int ban_duration;
    private String unban_date;
    private String Operation_record;
    public UserEntity() {
    }

    public UserEntity(Integer id, String account, String username, String password, String avatar, Boolean isAdmin, int ban_duration, String unban_date, String operation_record) {
        this.id = id;
        this.account = account;
        this.username = username;
        this.password = password;
        this.avatar = avatar;
        this.isAdmin = isAdmin;
        this.ban_duration = ban_duration;
        this.unban_date = unban_date;
        Operation_record = operation_record;
    }

    public int getBan_duration() {
        return ban_duration;
    }

    public void setBan_duration(int ban_duration) {
        this.ban_duration = ban_duration;
    }

    public String getUnban_date() {
        return unban_date;
    }

    public void setUnban_date(String unban_date) {
        this.unban_date = unban_date;
    }

    public String getOperation_record() {
        return Operation_record;
    }

    public void setOperation_record(String operation_record) {
        Operation_record = operation_record;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                ", isAdmin=" + isAdmin +
                ", ban_duration=" + ban_duration +
                ", unban_date='" + unban_date + '\'' +
                ", Operation_record='" + Operation_record + '\'' +
                '}';
    }
}
