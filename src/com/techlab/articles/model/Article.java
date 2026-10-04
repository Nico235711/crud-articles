package com.techlab.articles.model;

public class Article {
    private static long idGenerator = 0;
    private long id;
    private String name;
    private String description;
    private double price;
    public Article(String name, String description, double price) {
        idGenerator++;
        this.id = idGenerator;
        this.name = name;
        this.description = description;
        if (price > 0) {
            this.price = price;
        }
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public long getId() {
        return id;
    }
    @Override
    public String toString() {
        if (description == "") {
            return "Article [id=" + id + ", name=" + name + "," + "price=" + price + "]";
        }
        return "Article [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + "]";
    }
    
}
