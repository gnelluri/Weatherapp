package com.weather.weather_app.entity;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class WindEntity {
    @JsonProperty("speed")
    private double speed;

    @JsonProperty("deg")
    private int degree;

    @JsonProperty("gust")
    private Double gust;

}
