package com.java.PropertyProduct;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public final class FruitProperty extends SupermarketProperty{
    private SimpleIntegerProperty time;
    private SimpleDoubleProperty temperature;

    public FruitProperty(String departmentName, String productName, String country, double price, int time, double temperature) {
        super(departmentName, productName, country, price);
        this.time = new SimpleIntegerProperty(time);
        this.temperature =new SimpleDoubleProperty(temperature) ;
    }

    public int getTime() {
        return time.get();
    }

    public SimpleIntegerProperty timeProperty() {
        return time;
    }

    public void setTime(int time) {
        this.time.set(time);
    }

    public double getTemperature() {
        return temperature.get();
    }

    public SimpleDoubleProperty temperatureProperty() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature.set(temperature);
    }
}
