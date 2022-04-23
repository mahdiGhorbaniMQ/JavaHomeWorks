package com.company.model.car;

public class CarEnt {
    private int id;
    private String model;
    private String brand;
    private int price;

    public CarEnt(){}

    public CarEnt(String model, String brand, int price) {
        this.model = model;
        this.brand = brand;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public CarEnt setId(int id) {
        this.id = id;
        return this;
    }

    public String getModel() {
        return model;
    }

    public CarEnt setModel(String model) {
        this.model = model;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public CarEnt setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public CarEnt setPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return
                "brand: " + brand + "\n" +
                "model: " + model + "\n" +
                "price: " + price + "\n";
    }
}
