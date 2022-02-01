package pl.kkarpinski.association_rules.webClient.weather.dto;

import lombok.Getter;

/**
 * Created by kkarp.
 */
@Getter
public class OpenWeatherMainDto {

    private float temp;
    private int pressure;
    private int humidity;
}
