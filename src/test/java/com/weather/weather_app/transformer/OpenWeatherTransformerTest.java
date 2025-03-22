package com.weather.weather_app.transformer;

import com.weather.weather_app.domain.CityWeather;
import com.weather.weather_app.entity.OpenWeatherResponseEntity;
import com.weather.weather_app.entity.WeatherEntity;
import com.weather.weather_app.entity.WeatherResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class OpenWeatherTransformerTest {
    private OpenWeatherTransformer transformer;

    @BeforeEach
    public void setup(){
        transformer = new OpenWeatherTransformer();

    }
    @Test
    public void test_should_transfer_openweather_entity_to_domain(){
        final WeatherEntity weather= WeatherEntity.builder()
                .main("Rain")
                .description("Lot of Rains")
                .build();
        final WeatherEntity[] weatherEntities = {weather};
        final OpenWeatherResponseEntity entity = OpenWeatherResponseEntity.builder()
                .weather(weatherEntities)
                .build();

        final CityWeather cityWeather = transformer.transformToDomain(entity);

        assertAll("Should return weather domain object",
                ()-> assertEquals(entity.getWeather()[0].getMain(),cityWeather.getWeather()),
        () -> assertEquals(entity.getWeather()[0].getDescription(),cityWeather.getDetails()));
    }

    @Test
    public void test_should_transform_city_weather_to_entity(){
        final CityWeather cityWeather = CityWeather.builder()
                .weather("Rain")
                .details("Lot of Rains")
                .build();

        final WeatherResponse weatherResponse = transformer.transformToEntity(cityWeather);

        assertAll("Should return entity weather response object ",
                ()-> assertEquals(cityWeather.getWeather(),weatherResponse.getWeather()),
        ()-> assertEquals(cityWeather.getDetails(),weatherResponse.getDetails()));
    }
}