package com.sanzu.sanzuBook.vo;

public class UserCVo {
    private String username;
    private String account;
    private String password;
    private String avatar;

    public UserCVo() {
    }

    @Override
    public String toString() {
        return "UserCVo{" +
                "username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public UserCVo(String username, String account, String password, String avatar) {
        this.username = username;
        this.account = account;
        this.password = password;
        this.avatar = avatar;
    }
}
