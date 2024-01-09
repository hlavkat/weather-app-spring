package cz.weatherAPI.connector;

import cz.weatherAPI.City;
import cz.weatherAPI.dto.WeatherApiDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

public class WeatherApiConnector {
    //https://api.weatherapi.com/v1/current.json?key=12cbe7a59d254001b9b84802240501&q=Opava&aqi=no
    //https://api.weatherapi.com/v1/current.json?key=12cbe7a59d254001b9b84802240501&q=Bangkok&aqi=no
    private static String baseUrl="https://api.weatherapi.com/v1/";
    private static String urlParameters="current.json?key=";
    private static String APIKey="12cbe7a59d254001b9b84802240501";
    private static String url=baseUrl+urlParameters+APIKey+"&q=";

    public WeatherApiDto getWeatherForCity(City city){
        RestTemplate template=new RestTemplate();
        URI uri= null;
        try {
            uri = new URI(url+city.toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        ResponseEntity<WeatherApiDto> response=template.getForEntity(uri, WeatherApiDto.class);
        return response.getBody();
    }
}
