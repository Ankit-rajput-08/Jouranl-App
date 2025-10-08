package com.example.Journal.Service;

import com.example.Journal.apiResponce.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {

    @Value("${weather.api.key}")
    private  String apiKey;

    @Value("${weather.api.value}")
    private  String API;

    @Autowired
    private RestTemplate restTemplate;

    public WeatherResponse getWeather (String city){
        String finalApi =  API.replace("CITY",city).replace("API_KEY",apiKey);
        ResponseEntity<WeatherResponse> responce = restTemplate.exchange(finalApi, HttpMethod.GET,null, WeatherResponse.class);
        return responce.getBody();
    }
}
