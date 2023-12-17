package com.sanzu.sanzuBook.entity;

public class CollectEntity {
    private Integer id;
    private Integer userID;
    private String title;
    private String create_at;
    private String cover;
    private String author;
    private Integer bookID;

    public CollectEntity() {
    }

    public CollectEntity(Integer id, Integer userID, String title, String create_at, String cover, String author, Integer bookID) {
        this.id = id;
        this.userID = userID;
        this.title = title;
        this.create_at = create_at;
        this.cover = cover;
        this.author = author;
        this.bookID = bookID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
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
        return "CollectEntity{" +
                "id=" + id +
                ", userID=" + userID +
                ", title='" + title + '\'' +
                ", create_at='" + create_at + '\'' +
                ", cover='" + cover + '\'' +
                ", author='" + author + '\'' +
                ", bookID=" + bookID +
                '}';
    }
}
