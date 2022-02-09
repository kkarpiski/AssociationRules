package pl.kkarpinski.association_rules.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kkarpinski.association_rules.model.WeatherDto;
import pl.kkarpinski.association_rules.service.WeatherService;

/**
 * Created by kkarp.
 */

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherDto getWeather(){
        return weatherService.getWeather();

    }


}
