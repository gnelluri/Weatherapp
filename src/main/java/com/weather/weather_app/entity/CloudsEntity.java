package com.weather.weather_app.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CloudsEntity
{
    @JsonProperty("all")
    private int cloudiness;
}
