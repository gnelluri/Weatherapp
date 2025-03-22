package com.weather.weather_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class OpenWeatherResponseEntity {
    @JsonProperty("weather")
    private WeatherEntity[] weather;

    @JsonProperty("base")
    private String base;

    @JsonProperty("visibility")
    private int visibility;

    @JsonProperty("rain")
    private RainEntity rain;

    @JsonProperty("wind")
    private WindEntity wind;

    @JsonProperty("clouds")
    private CloudsEntity clouds;

    @JsonProperty("main")
    private MainEntity main;

    @JsonProperty("dt")
    private long dt;

    @JsonProperty("timezone")
    private int timezone;

    @JsonProperty("name")
    private String name;

    @JsonProperty("cod")
    private int cod;

    @JsonProperty("sys")
    private SysEntity sys;


}
