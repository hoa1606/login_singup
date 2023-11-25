package com.example.appreadingbooks;

import java.io.Serializable;

public class HomeModel implements Serializable {
    String id,title,coverImage,description,content,category,author;
    Double price;

    HomeModel() {

    }

    public HomeModel(String id, String title, String coverImage, String description, String content, String category, String author, Double price) {
        this.id = id;
        this.title = title;
        this.coverImage = coverImage;
        this.description = description;
        this.content = content;
        this.category = category;
        this.author = author;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
