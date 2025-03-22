package com.weather.weather_app.transformer;

import com.weather.weather_app.domain.Cordinates;
import com.weather.weather_app.entity.GeocodingCordinatesEntity;
import lombok.*;
import org.springframework.stereotype.Service;

@Service

//@NoArgsConstructor
public class GeocodingCordinatesTransformer {

    public Cordinates transformToDomain(final GeocodingCordinatesEntity entity) {
        /*return Cordinates.builder()
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .build();
    }*/
        return new Cordinates(entity.getLatitude(), entity.getLongitude());
    }


}
