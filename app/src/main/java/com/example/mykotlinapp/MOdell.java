package com.example.mykotlinapp;

import java.io.Serializable;

public class MOdell implements Serializable {

    String name;
    String price;
    boolean isSelected;

    public MOdell(String name, String price, boolean isSelected) {
        this.name = name;
        this.price = price;
        this.isSelected = isSelected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
