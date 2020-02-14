/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsu.finalproject.models;

/**
 *
 * @author carlos.chiquillo
 */
public class Product {
    private int id;
    private String name;
    private String description;
    private String category;
    private float price;

    public Product(String name, String description, String category, float price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }
    
    

    public Product(int id, String name, String description, String category, float price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    

   
}
