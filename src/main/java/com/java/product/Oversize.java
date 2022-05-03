package com.java.product;

import java.util.Objects;

public final class Oversize extends Supermarket{
    private double height;
    private double width;
    private double length;

    public Oversize() {
    }

    public Oversize(Supermarket supermarket) {
        super(supermarket);
    }

    public Oversize(String departmentName) {
        super(departmentName);
    }

    public Oversize(String departmentName, String productName) {
        super(departmentName, productName);
    }

    public Oversize(String departmentName, String productName, String country) {
        super(departmentName, productName, country);
    }

    public Oversize(String departmentName, String productName, String country, double price) {
        super(departmentName, productName, country, price);
    }

    public Oversize(String departmentName, String productName, String country, double price, double height) {
        super(departmentName, productName, country, price);
        this.height = height;
    }

    public Oversize(String departmentName, String productName, String country, double price, double height, double width) {
        super(departmentName, productName, country, price);
        this.height = height;
        this.width = width;
    }

    public Oversize(String departmentName, String productName, String country, double price, double height, double width, double length) {
        super(departmentName, productName, country, price);
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public Oversize(Supermarket supermarket, double height, double width, double length) {
        super(supermarket);
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Oversize oversize = (Oversize) o;
        return Double.compare(oversize.height, height) == 0 && Double.compare(oversize.width, width) == 0 && Double.compare(oversize.length, length) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height, width, length);
    }

    @Override
    public String toString() {
        return "Oversize{" +
                "height=" + height +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
