package com.weather.weather_app.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class WeatherRequestDetails {
    private String city;


}
