package cz.weatherAPI.service;

import cz.weatherAPI.City;
import cz.weatherAPI.connector.WeatherApiConnector;
import cz.weatherAPI.dto.WeatherApiDto;
import cz.weatherAPI.dto.WeatherDto;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {


    public WeatherDto getWeatherForCity(City cityEnum){
        WeatherApiConnector connector=new WeatherApiConnector();
        WeatherApiDto connectorWeatherForCity=connector.getWeatherForCity(cityEnum);
        return transformDto(connectorWeatherForCity);
    }

    private static WeatherDto transformDto(WeatherApiDto weatherApiDto) {
        WeatherDto weatherDto=new WeatherDto();
        weatherDto.setLocation(weatherApiDto.getLocation().getName());
        weatherDto.setWeather_description(weatherApiDto.getCurrent().getCondition().getText());
        weatherDto.setTemp_celsius(weatherApiDto.getCurrent().getTemp_c());
        weatherDto.setRel_humidity(weatherApiDto.getCurrent().getHumidity());
        weatherDto.setWindSpeed_mps(Math.round(weatherApiDto.getCurrent().getWind_kph()/3.6));
        weatherDto.setWind_direction(weatherApiDto.getCurrent().getWind_dir());
        weatherDto.setTimestamp(weatherApiDto.getCurrent().getLast_updated());
        return weatherDto;
    }
}
