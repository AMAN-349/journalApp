package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.api.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    private static final String apikey = "6a16e570c3a551801abb07e87301e8d7";

    private static final String API="http://api.weatherstack.com/current?access_key=API_KEY&query=CITY";

    @Autowired
    private RestTemplate restTemplate;
    //this is class in spring that process http request and gives us response

    public WeatherResponse getWeather(String city)
    {
        String finalAPI = API.replace("CITY",city).replace("API_KEY",apikey);
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalAPI, HttpMethod.GET,null, WeatherResponse.class); //it deserialize json to pojo
        //response.getStatusCode() use if want to throw error or etc.
        WeatherResponse body = response.getBody();
        return body;
    }
}
