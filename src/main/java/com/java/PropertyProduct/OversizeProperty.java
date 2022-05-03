package com.java.PropertyProduct;

import com.java.product.Supermarket;
import javafx.beans.property.SimpleDoubleProperty;

public final class OversizeProperty extends SupermarketProperty {
    private SimpleDoubleProperty height;
    private SimpleDoubleProperty width;
    private SimpleDoubleProperty length;

    public OversizeProperty(String departmentName, String productName, String country, double price, double height, double width, double length) {
        super(departmentName, productName, country, price);
        this.height =new SimpleDoubleProperty(height) ;
        this.width =new SimpleDoubleProperty(width) ;
        this.length =new SimpleDoubleProperty(length) ;
    }

    public double getHeight() {
        return height.get();
    }

    public SimpleDoubleProperty heightProperty() {
        return height;
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    public double getWidth() {
        return width.get();
    }

    public SimpleDoubleProperty widthProperty() {
        return width;
    }

    public void setWidth(double width) {
        this.width.set(width);
    }

    public double getLength() {
        return length.get();
    }

    public SimpleDoubleProperty lengthProperty() {
        return length;
    }

    public void setLength(double length) {
        this.length.set(length);
    }
}
