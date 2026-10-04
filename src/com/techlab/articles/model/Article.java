package com.techlab.articles.model;

public class Article {
    private String name;
    private String description;
    private Double price;
    public Article(String name, String description, Double price) {
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
    public Double getPrice() {
        return price;
    }
}
