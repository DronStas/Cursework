package com.java.product;

import java.util.Objects;

public final class Fruit extends Supermarket {
    private int time;
    private double temperature;

    public Fruit() {
    }

    public Fruit(Supermarket supermarket) {
        super(supermarket);
    }

    public Fruit(String departmentName) {
        super(departmentName);
    }

    public Fruit(String departmentName, String productName) {
        super(departmentName, productName);
    }

    public Fruit(String departmentName, String productName, String country) {
        super(departmentName, productName, country);
    }

    public Fruit(String departmentName, String productName, String country, double price) {
        super(departmentName, productName, country, price);
    }

    public Fruit(String departmentName, String productName, String country, double price, int time) {
        super(departmentName, productName, country, price);
        this.time = time;
    }

    public Fruit(String departmentName, String productName, String country, double price, int time, double temperature) {
        super(departmentName, productName, country, price);
        this.time = time;
        this.temperature = temperature;
    }

    public Fruit(Supermarket supermarket, int time, double temperature) {
        super(supermarket);
        this.time = time;
        this.temperature = temperature;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Fruit fruit = (Fruit) o;
        return time == fruit.time && Double.compare(fruit.temperature, temperature) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), time, temperature);
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "time=" + time +
                ", temperature=" + temperature +
                '}';
    }
}
