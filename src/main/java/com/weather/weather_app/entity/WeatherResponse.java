package com.weather.weather_app.entity;


import lombok.*;

@Builder
//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data

public class WeatherResponse {

    private String weather;
    private String details;
    private Double temperature;
    private Double feelsLike;
    private Integer humidity;
    private Integer pressure;
    private Integer visibility;
    private Double windSpeed;
    private Double windGust;
    private Double rainVolume;
    private Integer cloudiness;
    private String country;
    private Long sunrise;
    private Long sunset;
    private String cityName;

    // Constructor
    public WeatherResponse(String weather, String details, Double temperature, Double feelsLike, Integer humidity,
                           Integer pressure, Integer visibility, Double windSpeed, Double windGust, Double rainVolume,
                           Integer cloudiness, String country, Long sunrise, Long sunset, String cityName) {
        this.weather = weather;
        this.details = details;
        this.temperature = temperature;
        this.feelsLike = feelsLike;
        this.humidity = humidity;
        this.pressure = pressure;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
        this.windGust = windGust;
        this.rainVolume = rainVolume;
        this.cloudiness = cloudiness;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.cityName = cityName;
    }

    // Getters
    public String getWeather() { return weather; }
    public String getDetails() { return details; }
    public Double getTemperature() { return temperature; }
    public Double getFeelsLike() { return feelsLike; }
    public Integer getHumidity() { return humidity; }
    public Integer getPressure() { return pressure; }
    public Integer getVisibility() { return visibility; }
    public Double getWindSpeed() { return windSpeed; }
    public Double getWindGust() { return windGust; }
    public Double getRainVolume() { return rainVolume; }
    public Integer getCloudiness() { return cloudiness; }
    public String getCountry() { return country; }
    public Long getSunrise() { return sunrise; }
    public Long getSunset() { return sunset; }
    public String getCityName() { return cityName; }
}
