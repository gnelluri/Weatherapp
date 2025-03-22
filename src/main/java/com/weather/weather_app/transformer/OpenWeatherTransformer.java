package com.weather.weather_app.transformer;

import com.weather.weather_app.domain.CityWeather;
import com.weather.weather_app.entity.OpenWeatherResponseEntity;
import com.weather.weather_app.entity.WeatherResponse;
import lombok.*;
import org.springframework.stereotype.Service;

@Builder
@Service
@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@Data
public class OpenWeatherTransformer {

    public CityWeather transformToDomain(final OpenWeatherResponseEntity entity) {

        CityWeather cityWeather = new CityWeather();
        cityWeather.setWeather(entity.getWeather()[0].getMain());
        cityWeather.setDetails(entity.getWeather()[0].getDescription());
        cityWeather.setTemperature(entity.getMain().getTemp());
        cityWeather.setFeelsLike(entity.getMain().getFeelsLike());
        cityWeather.setHumidity(entity.getMain().getHumidity());
        cityWeather.setPressure(entity.getMain().getPressure());
        cityWeather.setVisibility(entity.getVisibility());
        cityWeather.setWindSpeed(entity.getWind() != null ? entity.getWind().getSpeed() : null);
        cityWeather.setWindGust(entity.getWind() != null ? entity.getWind().getGust() : null);
        cityWeather.setRainVolume(entity.getRain() != null ? entity.getRain().getOneHour() : null);
        cityWeather.setCloudiness(entity.getClouds() != null ? entity.getClouds().getCloudiness() : null);
        cityWeather.setCountry(entity.getSys().getCountry());
        cityWeather.setSunrise(entity.getSys().getSunrise());
        cityWeather.setSunset(entity.getSys().getSunset());
        cityWeather.setCityName(entity.getName());

        return cityWeather;
    }

    public static WeatherResponse transformToEntity(final CityWeather cityWeather) {
        return new WeatherResponse(cityWeather.getWeather(),
                cityWeather.getDetails(),
                cityWeather.getTemperature(),
                cityWeather.getFeelsLike(),
                cityWeather.getHumidity(),
                cityWeather.getPressure(),
                cityWeather.getVisibility(),
                cityWeather.getWindSpeed(),
                cityWeather.getWindGust(),
                cityWeather.getRainVolume(),
                cityWeather.getCloudiness(),
                cityWeather.getCountry(),
                cityWeather.getSunrise(),
                cityWeather.getSunset(),
                cityWeather.getCityName());
    }
}
