package com.example.task51c;

public class MainModel {
    int images;
    String cityName;

    public MainModel(int images, String cityName) {
        this.images = images;
        this.cityName = cityName;
    }

    public int getImages() {
        return images;
    }

    public String getCityName() {
        return cityName;
    }
}
