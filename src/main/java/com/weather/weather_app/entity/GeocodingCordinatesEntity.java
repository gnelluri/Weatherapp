package com.weather.weather_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@Data

public class GeocodingCordinatesEntity {
    @JsonProperty("lat")
    private String latitude;
    @JsonProperty("lon")
    private String Longitude;

    public GeocodingCordinatesEntity(String latitude, String longitude) {
        this.latitude = latitude;
        this.Longitude = longitude;
    }

    // Getter for latitude
    public String getLatitude() {
        return latitude;
    }

    // Getter for longitude
    public String getLongitude() {
        return Longitude;
    }

    // Optional Setter methods if needed
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(String longitude) {
        this.Longitude = longitude;
    }




}
