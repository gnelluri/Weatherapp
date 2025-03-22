package com.weather.weather_app.service;

import com.weather.weather_app.domain.CityWeather;
import com.weather.weather_app.domain.Cordinates;
import com.weather.weather_app.domain.WeatherRequestDetails;
import com.weather.weather_app.entity.OpenWeatherResponseEntity;
import com.weather.weather_app.entity.WeatherResponse;
import com.weather.weather_app.provider.GeocodingProvider;
import com.weather.weather_app.provider.WeatherProvider;
import com.weather.weather_app.transformer.GeocodingCordinatesTransformer;
import com.weather.weather_app.transformer.OpenWeatherTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class WeatherService {

    /*private static GeocodingProvider geocodingProvider;
    private static GeocodingCordinatesTransformer geocodingCordinatesTransformer;
    private static WeatherProvider weatherProvider;
    private static OpenWeatherTransformer openWeatherTransformer;

    @Autowired
    public WeatherService(final GeocodingProvider geocodingProvider,
                          final GeocodingCordinatesTransformer geocodingCordinatesTransformer,
                          final WeatherProvider weatherProvider,
                          final OpenWeatherTransformer openWeatherTransformer){
        this.geocodingProvider=geocodingProvider;
        this.geocodingCordinatesTransformer =geocodingCordinatesTransformer;
        this.openWeatherTransformer = openWeatherTransformer;
        this.weatherProvider = weatherProvider;
    }

    public static WeatherResponse getWeather(WeatherRequestDetails weatherRequestDetails) throws Exception {
        //get latitude and longitude
        final Cordinates cordinates = geocodingCordinatesTransformer
                .transformToDomain(geocodingProvider.getcordinates(weatherRequestDetails));



        final CityWeather cityWeather = openWeatherTransformer.
                transformToDomain(weatherProvider.getWeather(cordinates));

                return openWeatherTransformer.transformToEntity(cityWeather);
    }*/

    private static GeocodingProvider geocodingProvider;
    private static GeocodingCordinatesTransformer geocodingCordinatesTransformer;
    private static WeatherProvider weatherProvider;
    private static OpenWeatherTransformer openWeatherTransformer;

    @Autowired
    public WeatherService(final GeocodingProvider geocodingProvider,
                          final GeocodingCordinatesTransformer geocodingCordinatesTransformer,
                          final WeatherProvider weatherProvider,
                          final OpenWeatherTransformer openWeatherTransformer) {
        this.geocodingProvider = geocodingProvider;
        this.geocodingCordinatesTransformer = geocodingCordinatesTransformer;
        this.weatherProvider = weatherProvider;
        this.openWeatherTransformer = openWeatherTransformer;
    }

    public static WeatherResponse getWeather(WeatherRequestDetails weatherRequestDetails) throws Exception {
        // Get latitude and longitude from geocoding
        final Cordinates coordinates = geocodingCordinatesTransformer
                .transformToDomain(geocodingProvider.getcordinates(weatherRequestDetails));

        // Get weather details from OpenWeather API
        final OpenWeatherResponseEntity openWeatherResponse = weatherProvider.getWeather(coordinates);

        // Transform to domain model
        final CityWeather cityWeather = openWeatherTransformer.transformToDomain(openWeatherResponse);

        // Transform to API response
        return openWeatherTransformer.transformToEntity(cityWeather);

    }


}
