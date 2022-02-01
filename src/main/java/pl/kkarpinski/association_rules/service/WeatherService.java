package pl.kkarpinski.association_rules.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kkarpinski.association_rules.model.WeatherDto;
import pl.kkarpinski.association_rules.webClient.weather.WeatherClient;

/**
 * Created by kkarp.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherDto getWeather(){
        return weatherClient.getWeatherForLatAndLon(weatherClient.gegrLat, weatherClient.gegrLon);
    }


}
