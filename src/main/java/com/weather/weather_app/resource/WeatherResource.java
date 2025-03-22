package com.weather.weather_app.resource;

import com.weather.weather_app.domain.WeatherRequestDetails;
import com.weather.weather_app.entity.WeatherResponse;
import com.weather.weather_app.service.WeatherService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")


/*public class WeatherResource {

    private WeatherService weatherService;

    @Autowired
    public WeatherResource (final WeatherService weatherService){
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{city}")
    public @ResponseBody WeatherResponse weather(@PathVariable("city") String city) throws Exception{

        final WeatherRequestDetails weatherRequestDetails = WeatherRequestDetails.builder()
                .city(city).build();

        return WeatherService.getWeather(weatherRequestDetails);
    }



}*/
@Builder
public class WeatherResource {

    private final WeatherService weatherService;

    @Autowired
    public WeatherResource(final WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/{city}")
    public @ResponseBody WeatherResponse weather(@PathVariable("city") String city) {
        try {
            final WeatherRequestDetails weatherRequestDetails = WeatherRequestDetails.builder()
                    .city(city)
                    .build();

            // Call the service method via the instance (not statically)
            return WeatherService.getWeather(weatherRequestDetails);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving weather information: " + e.getMessage(), e);
        }
    }
}
