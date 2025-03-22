package com.weather.weather_app.provider;

import com.weather.weather_app.domain.WeatherRequestDetails;
import com.weather.weather_app.entity.GeocodingCordinatesEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodingProvider {

    @Value("${api.key}")
    private String apikey;

    @Value("${geocoding.url}")
    private String geocodingUrl;

    public GeocodingCordinatesEntity getcordinates(WeatherRequestDetails weatherRequestDetails) throws Exception {

        //API call
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<GeocodingCordinatesEntity[]> responseEntity;

        HttpEntity<String> requestEntity = new HttpEntity<>(null,null);

        //Buid URL
        UriComponents uriBuilder = UriComponentsBuilder.fromUriString(geocodingUrl)
                .queryParam("q",weatherRequestDetails.getCity())
                .queryParam("limit","1")
                .queryParam("appid",apikey).build();

        try{
            responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
                    HttpMethod.GET,
                    requestEntity,
                    GeocodingCordinatesEntity[].class);
        }

        catch (HttpStatusCodeException e){
            throw new Exception(e.getMessage());
        }

        return responseEntity.getBody()[0];


    }
}
