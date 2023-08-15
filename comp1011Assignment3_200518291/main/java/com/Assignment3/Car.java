package com.Assignment3;

public class Car {
    private int imageId;
    private String name;
    private String price;
    private String description;

    public Car(int imageId, String name, String price, String description) {
        this.imageId = imageId;
        this.name = name;
        this.price = price;
        this.description = description;
    }
    private boolean sold;

    public Car(boolean sold) {
        this.sold = sold;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
    }

    public void setPrice(String price) {
    }

    public void setMakeModel(String makeModel) {
    }

    public boolean getMake() {
    }

    public boolean getModel() {
    }

    public boolean getCondition() {
    }

    public boolean getEngineCylinders() {
    }

    public boolean getYear() {
    }

    public boolean getNumberOfDoors() {
    }

    public boolean getColor() {
    }

    public boolean getDateSold() {
    }
}

