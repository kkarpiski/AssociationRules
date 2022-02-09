package pl.kkarpinski.association_rules.webClient.weather;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.kkarpinski.association_rules.model.WeatherDto;
import pl.kkarpinski.association_rules.webClient.weather.dto.OpenWeatherWeatherDto;
import pl.kkarpinski.association_rules.webClient.gios.GiosClient;

/**
 * Created by kkarp.
 */

@Component
public class WeatherClient {


    public String gegrLat = "51.775411";
    public String gegrLon = "19.450900";
    private static final String API_KEY = "965da2d6960fddd34e98e126cc14b583";
    private static final String API_BASE_ADDRESS = "https://api.openweathermap.org/data/2.5/";
    private RestTemplate restTemplate = new RestTemplate();

    public WeatherDto getWeatherForLatAndLon(String gegrLat, String gegrLon) {
        OpenWeatherWeatherDto openWeatherWeatherDto = callGetMethod("weather?lat={gegrLat}&lon={gegrLon}&appid={API_KEY}",
                OpenWeatherWeatherDto.class,
                gegrLat, gegrLon, API_KEY);
        return WeatherDto.builder()
                .temperature(openWeatherWeatherDto.getMain().getTemp())
                .pressure(openWeatherWeatherDto.getMain().getPressure())
                .humidity(openWeatherWeatherDto.getMain().getHumidity())
                .windSpeed(openWeatherWeatherDto.getWind().getSpeed())
                .build();
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(API_BASE_ADDRESS + url,
                responseType, objects);
    }
}

