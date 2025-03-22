package com.weather.weather_app.provider;

import com.weather.weather_app.domain.Cordinates;
import com.weather.weather_app.entity.OpenWeatherResponseEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Component


public class WeatherProvider {
    @Value("${api.key}")
    private static String apiKey;

    @Value(("${weather.url}"))
    private static String weatherUrl;

    public static OpenWeatherResponseEntity getWeather(final Cordinates cordinates) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<OpenWeatherResponseEntity> responseEntity;

        HttpEntity<String> requestEntity = new HttpEntity<>(null,null);

        //Buid URL
        UriComponents uriBuilder = UriComponentsBuilder.fromUriString(weatherUrl)
                .queryParam("lat",cordinates.getLatitude())
                .queryParam("lon",cordinates.getLongitude())
                .queryParam("appid",apiKey).build();

        try{
            responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
                    HttpMethod.GET,
                    requestEntity,
                    OpenWeatherResponseEntity.class);
        }

        catch (HttpStatusCodeException e){
            throw new Exception(e.getMessage());
        }

        return responseEntity.getBody();
    }


}
