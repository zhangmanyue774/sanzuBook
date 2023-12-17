package com.sanzu.sanzuBook.entity;

public class ReviewEntity {
    private int id;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String username;
    private String review;
    private String title;
    private String cover;
    private String created_at;
    private String likes;

    private String avatar;
    private String author;
    private Integer bookID;

    public ReviewEntity() {
    }

    public ReviewEntity(int id, String email, String username, String review, String title, String cover, String created_at, String likes, String avatar, String author, Integer bookID) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.review = review;
        this.title = title;
        this.cover = cover;
        this.created_at = created_at;
        this.likes = likes;
        this.avatar = avatar;
        this.author = author;
        this.bookID = bookID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getBookID() {
        return bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    @Override
    public String toString() {
        return "ReviewEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", review='" + review + '\'' +
                ", title='" + title + '\'' +
                ", cover='" + cover + '\'' +
                ", created_at='" + created_at + '\'' +
                ", likes='" + likes + '\'' +
                ", avatar='" + avatar + '\'' +
                ", author='" + author + '\'' +
                ", bookID=" + bookID +
                '}';
    }
}
