package com.weather.weather_app.transformer;

import com.weather.weather_app.entity.GeocodingCordinatesEntity;
import com.weather.weather_app.domain.Cordinates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeocodingCordinatesTransformerTest {

    private GeocodingCordinatesTransformer transformer;

    @BeforeEach
    public void setup() {
        transformer = new GeocodingCordinatesTransformer();
    }

    @Test
    public void test_should_transform_geocoding_coordinates_to_main(){
        final GeocodingCordinatesEntity entity =
                GeocodingCordinatesEntity.builder()
                        .Longitude("12.0")
                        .latitude("14.0")
                        .build();

        final Cordinates cityCordinates = transformer.transformToDomain(entity);

        assertAll("Should return domain city Cordinates",
                () -> assertEquals(entity.getLatitude(),cityCordinates.getLatitude()),
                () -> assertEquals(entity.getLongitude(),cityCordinates.getLongitude()));

    }


}