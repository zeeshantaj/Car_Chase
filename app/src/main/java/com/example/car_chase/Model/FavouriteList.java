package com.example.car_chase.Model;

public class FavouriteList {
    private String carTitle,carPrice,carRating,carVotes;
    private int carImage;

    public FavouriteList(String carTitle, String carPrice, String carRating, String carVotes, int carImage) {
        this.carTitle = carTitle;
        this.carPrice = carPrice;
        this.carRating = carRating;
        this.carVotes = carVotes;
        this.carImage = carImage;
    }

    public String getCarTitle() {
        return carTitle;
    }

    public void setCarTitle(String carTitle) {
        this.carTitle = carTitle;
    }

    public String getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(String carPrice) {
        this.carPrice = carPrice;
    }

    public String getCarRating() {
        return carRating;
    }

    public void setCarRating(String carRating) {
        this.carRating = carRating;
    }

    public String getCarVotes() {
        return carVotes;
    }

    public void setCarVotes(String carVotes) {
        this.carVotes = carVotes;
    }

    public int getCarImage() {
        return carImage;
    }

    public void setCarImage(int carImage) {
        this.carImage = carImage;
    }
}
