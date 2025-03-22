package com.weather.weather_app.service;

import com.weather.weather_app.domain.Cordinates;
import com.weather.weather_app.domain.WeatherRequestDetails;
import com.weather.weather_app.entity.GeocodingCordinatesEntity;
import com.weather.weather_app.entity.OpenWeatherResponseEntity;
import com.weather.weather_app.entity.WeatherEntity;
import com.weather.weather_app.entity.WeatherResponse;
import com.weather.weather_app.provider.GeocodingProvider;
import com.weather.weather_app.provider.WeatherProvider;
import com.weather.weather_app.transformer.GeocodingCordinatesTransformer;
import com.weather.weather_app.transformer.OpenWeatherTransformer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(WeatherService.class)
class WeatherServiceTest {

    @MockitoBean
    private GeocodingCordinatesTransformer geocodingCordinatesTransformer;
    @MockitoBean
    private GeocodingProvider geocodingProvider;
    @MockitoBean
    private WeatherProvider weatherProvider;
    @MockitoBean
    private OpenWeatherTransformer openWeatherTransformer;

    @InjectMocks
    private WeatherService weatherService;

    @Test
    public void Test_should_return_weather_response() throws Exception {

        final WeatherRequestDetails weatherRequestDetails = WeatherRequestDetails.builder()
                .city("Binghamton")
                .build();

        mockGeocodingProvider(weatherRequestDetails);
        mockGeocodingCordinatesTransformer();
        mockWeatherProvider();
        mockOpenWeatherTransformer();

        final WeatherResponse weatherResponse = WeatherService.getWeather(weatherRequestDetails);
        assertAll("Should return city weather",
                ()->assertEquals("Rain",weatherResponse.getWeather()),
        ()-> assertEquals("Lot of Rains",weatherResponse.getDetails()));

    }

    private void mockOpenWeatherTransformer() {
        final WeatherResponse response = WeatherResponse.builder()
                .weather("Rain")
                .details("Lot of Rains")
                .build();

        when(OpenWeatherTransformer.transformToEntity(any())).thenReturn(response);


    }

    private void mockWeatherProvider() throws Exception {
        final WeatherEntity weather= WeatherEntity.builder()
                .main("Rain")
                .description("Lot of Rains")
                .build();
        final WeatherEntity[] weatherEntities = {weather};
        final OpenWeatherResponseEntity entity = OpenWeatherResponseEntity.builder()
                .weather(weatherEntities)
                .build();

        when(WeatherProvider.getWeather(any())).thenReturn(entity);
    }

    private void mockGeocodingCordinatesTransformer() {
        final Cordinates cordinates = Cordinates.builder()
                .latitude("12.56")
                .longitude("23.56")
                .build();
        when(geocodingCordinatesTransformer.transformToDomain(any())).thenReturn(cordinates);
    }

    private void mockGeocodingProvider(final WeatherRequestDetails weatherRequestDetails) throws Exception {
        final GeocodingCordinatesEntity entity = GeocodingCordinatesEntity.builder()
                .latitude("12.56")
                .Longitude("23.56")
                .build();

        when(geocodingProvider.getcordinates(weatherRequestDetails)).thenReturn(entity);

    }


}