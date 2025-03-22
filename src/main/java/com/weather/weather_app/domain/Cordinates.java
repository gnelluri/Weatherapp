package com.weather.weather_app.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder


public class Cordinates {

    private String latitude;
    private String longitude;

    public Cordinates(String latitude, String longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getter for latitude
    public String getLatitude() {
        return latitude;
    }

    // Getter for longitude
    public String getLongitude() {
        return longitude;
    }

    // Optional: Setter methods
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
