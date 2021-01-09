package com.app.libraryapigateway.pojos;

public class Book {
    private Long id;

    private String name;
    private String author;
    private String description;
    private String price;
    private String imgPath;

    public Book() {}

    public Book(Long id, String name, String author, String description, String price, String imgPath) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.price = price;
        this.imgPath = imgPath;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", imgPath='" + imgPath + '\'' +
                '}';
    }
}
