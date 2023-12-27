package com.example.car_chase.Model;

public class BrandList {
    private String brandTitle;
    private int brandImage;

    public BrandList(String brandTitle, int brandImage) {
        this.brandTitle = brandTitle;
        this.brandImage = brandImage;
    }

    public String getBrandTitle() {
        return brandTitle;
    }

    public void setBrandTitle(String brandTitle) {
        this.brandTitle = brandTitle;
    }

    public int getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(int brandImage) {
        this.brandImage = brandImage;
    }
}
