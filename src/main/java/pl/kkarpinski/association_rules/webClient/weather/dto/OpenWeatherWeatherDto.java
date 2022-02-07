package pl.kkarpinski.association_rules.webClient.weather.dto;

import lombok.Getter;

/**
 * Created by kkarp.
 */
@Getter
public class OpenWeatherWeatherDto {

    private OpenWeatherMainDto main;
    private OpenWeatherWindDto wind;

}
