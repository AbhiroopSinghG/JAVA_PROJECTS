/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1.djava;

import java.util.Objects;

/**
 *
 * @author Abhi
 */
public class Product {
    private int id;
    private String name;
    private double price;
    private int quantity;
    
    public Product(){
        this(0,"NA",0,0);
    }
    
    public Product(int id, String name, double price, int quantity){
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return " Product id:"+this.getId()+" Product name:"+this.getName()+" Product price"+this.getPrice()+" Product quantity"+this.getQuantity();
    }
    
}
