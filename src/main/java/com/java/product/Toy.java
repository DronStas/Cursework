package com.java.product;

import java.util.Objects;

public final class Toy extends Supermarket {
    private int ageGroup;
    private String type;

    public Toy() {
    }

    public Toy(String departmentName) {
        super(departmentName);
    }

    public Toy(String departmentName, String productName) {
        super(departmentName, productName);
    }

    public Toy(String departmentName, String productName, String country) {
        super(departmentName, productName, country);
    }

    public Toy(String departmentName, String productName, String country, double price) {
        super(departmentName, productName, country, price);
    }

    public Toy(String departmentName, String productName, String country, double price, int ageGroup) {
        super(departmentName, productName, country, price);
        this.ageGroup = ageGroup;
    }

    public Toy(String departmentName, String productName, String country, double price, int ageGroup, String type) {
        super(departmentName, productName, country, price);
        this.ageGroup = ageGroup;
        this.type = type;
    }

    public Toy(Supermarket supermarket, int ageGroup, String type) {
        super(supermarket);
        this.ageGroup = ageGroup;
        this.type = type;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Toy toy = (Toy) o;
        return ageGroup == toy.ageGroup && Objects.equals(type, toy.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), ageGroup, type);
    }

    @Override
    public String toString() {
        return super.toString()+ "Toy{" +
                "ageGroup=" + ageGroup +
                ", type='" + type + '\'' +
                '}';
    }

}
