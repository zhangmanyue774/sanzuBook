package com.sanzu.sanzuBook.entity;

public class BookEntity {
    private Integer id;
    private String title;
    private String author;
    private String cover;
    private String describe;
    private Integer recommended;
    private String type;
    private Integer likes;

    public BookEntity() {
    }

    public BookEntity(Integer id, String title, String author, String cover, String describe, Integer recommended, String type, Integer likes) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.cover = cover;
        this.describe = describe;
        this.recommended = recommended;
        this.type = type;
        this.likes = likes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Integer getRecommended() {
        return recommended;
    }

    public void setRecommended(Integer recommended) {
        this.recommended = recommended;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", cover='" + cover + '\'' +
                ", describe='" + describe + '\'' +
                ", recommended=" + recommended +
                ", type='" + type + '\'' +
                ", likes=" + likes +
                '}';
    }
}
