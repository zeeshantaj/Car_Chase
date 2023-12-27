package com.example.car_chase.Model;

public class CarModelList {
    private String carName,carPrice,rating;
    private int carImage;

    public CarModelList(String carName, String carPrice,String rating, int carImage) {
        this.carName = carName;
        this.carPrice = carPrice;
        this.rating = rating;
        this.carImage = carImage;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getCarImage() {
        return carImage;
    }

    public void setCarImage(int carImage) {
        this.carImage = carImage;
    }
}
