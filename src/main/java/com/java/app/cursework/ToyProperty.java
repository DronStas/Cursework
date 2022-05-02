package com.java.app.cursework;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ToyProperty extends SupermarketProperty {
    public SimpleIntegerProperty ageGroup;
    public SimpleStringProperty type;

    public ToyProperty(String departmentName, String productName, String country, double price, int ageGroup, String type) {
        super(departmentName, productName, country, price);
        this.ageGroup = new SimpleIntegerProperty(ageGroup);
        this.type =new SimpleStringProperty(type);
    }

    public int getAgeGroup() {
        return ageGroup.get();
    }

    public SimpleIntegerProperty ageGroupProperty() {
        return ageGroup;
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = new SimpleIntegerProperty(ageGroup);
    }

    public void setType(String type) {
        this.type =new SimpleStringProperty(type);
    }
}

