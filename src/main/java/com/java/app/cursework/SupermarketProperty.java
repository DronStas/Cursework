package com.java.app.cursework;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class SupermarketProperty {
    public   SimpleStringProperty departmentName;
    public SimpleStringProperty productName;
    public SimpleStringProperty country;
    public SimpleDoubleProperty price;

    public SupermarketProperty(String departmentName, String productName, String country, double price) {
        this.departmentName =new SimpleStringProperty(departmentName) ;
        this.productName = new SimpleStringProperty(productName);
        this.country =new SimpleStringProperty(country); ;
        this.price =new SimpleDoubleProperty(price) ;
    }

    public String getDepartmentName() {
        return departmentName.get();
    }

    public SimpleStringProperty departmentNameProperty() {
        return departmentName;
    }

    public String getProductName() {
        return productName.get();
    }

    public SimpleStringProperty productNameProperty() {
        return productName;
    }

    public String getCountry() {
        return country.get();
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return price;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName =new SimpleStringProperty(departmentName);
    }

    public void setProductName(String productName) {
        this.productName = new SimpleStringProperty(productName);
    }

    public void setCountry(String country) {
        this.country =new SimpleStringProperty(country);
    }

    public void setPrice(double price) {
        this.price =new SimpleDoubleProperty(price) ;
    }
}

