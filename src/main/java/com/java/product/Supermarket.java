package com.java.product;

import java.util.Objects;

public  class Supermarket {
    private String departmentName;
    private String productName;
    private String country;
    private double price;

    public Supermarket() {
    }
    public Supermarket(Supermarket supermarket) {
        this.departmentName = supermarket.departmentName;
        this.productName = supermarket.productName;
        this.country = supermarket.country;
        this.price = supermarket.price;
    }

    public Supermarket(String departmentName) {
        this.departmentName = departmentName;
    }

    public Supermarket(String departmentName, String productName) {
        this.departmentName = departmentName;
        this.productName = productName;
    }

    public Supermarket(String departmentName, String productName, String country) {
        this.departmentName = departmentName;
        this.productName = productName;
        this.country = country;
    }

    public Supermarket(String departmentName, String productName, String country, double price) {
        this.departmentName = departmentName;
        this.productName = productName;
        this.country = country;
        this.price = price;
    }

    public  Supermarket getSupermarket() {
        return new Supermarket(departmentName,productName,country,price);
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supermarket that = (Supermarket) o;
        return Double.compare(that.price, price) == 0 && Objects.equals(departmentName, that.departmentName) && Objects.equals(productName, that.productName) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName, productName, country, price);
    }

    @Override
    public String toString() {
        return "Supermarket{" +
                "departmentName='" + departmentName + '\'' +
                ", productName='" + productName + '\'' +
                ", country='" + country + '\'' +
                ", price=" + price +
                '}';
    }
}
